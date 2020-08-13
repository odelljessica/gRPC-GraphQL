package com.personal.grpc;

import com.personal.models.AladdinGraphQLServiceGrpc;
import com.personal.models.GraphQLRequest;
import com.personal.models.GraphQLResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * AladdinGraphQLService(Grpc) is defined as a Service in the proto file, graphService.proto
 */
@Service
public class AladdinGraphQLServiceGrpcImpl extends AladdinGraphQLServiceGrpc.AladdinGraphQLServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AladdinGraphQLServiceGrpcImpl.class);

    /**
     * Execute method is defined in the QuasarGraphQLService service at the proto file.
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void execute(GraphQLRequest request, StreamObserver<GraphQLResponse> responseObserver) {
        // TODO: Consume eFront
    }

}
