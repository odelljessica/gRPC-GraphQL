package com.personal.grpc;

import com.personal.models.GraphQLRequest;
import com.personal.models.GraphQLResponse;
import com.personal.models.QuasarGraphQLServiceGrpc;
import com.personal.service.GraphQLService;
import com.google.api.graphql.execution.GuavaListenableFutureSupport;
import com.google.api.graphql.grpc.QueryResponseToProto;
import com.google.api.graphql.grpc.RejoinerStreamingContext;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * QuasarGraphQLService(Grpc) is defined as a Service in the proto file, graphService.proto
 */
@Service
@Transactional //Puts everything in same scope
public class QuasarGraphQLServiceGrpcImpl extends QuasarGraphQLServiceGrpc.QuasarGraphQLServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuasarGraphQLServiceGrpcImpl.class);

    private static final Instrumentation instrumentation =
        new ChainedInstrumentation(Arrays.asList(GuavaListenableFutureSupport.listenableFutureInstrumentation()));

    @Autowired
    private GraphQLService graphqlService;

    /**
     * BlockingStub
     * Execute method is defined in the QuasarGraphQLService service at the proto file.
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void execute(GraphQLRequest request, StreamObserver<GraphQLResponse> responseObserver) {

        // Rejoiner Middleware to maintain gRPC aware of the execution of the graphQL process.
        RejoinerStreamingContext<GraphQLResponse> context = RejoinerStreamingContext.create(responseObserver);

        ExecutionInput executionInput =
            ExecutionInput.newExecutionInput()
                .query(request.getQuery())
                .context(context)
                .build();

        // GraphQL process that consumes Quasar DB.
        ExecutionResult executionResult = this.graphqlService.getGraphQL(instrumentation).execute(executionInput);

        // Mediating/mapping GraphQL Response into Model defined as Service response at proto file.
        GraphQLResponse graphQlResponse =
            QueryResponseToProto.buildMessage(GraphQLResponse.getDefaultInstance(), executionResult.toSpecification());

        try {
            LOGGER.info("Response in Json format: " + JsonFormat.printer().print(graphQlResponse));
        } catch (InvalidProtocolBufferException e) {
            LOGGER.error("Response proto is invalid", e);
        }

        // Sending the response to the Stream
        responseObserver.onNext(graphQlResponse);

        try {
            context.awaitStreams();
        } catch (InterruptedException e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onCompleted();
        }
    }

}
