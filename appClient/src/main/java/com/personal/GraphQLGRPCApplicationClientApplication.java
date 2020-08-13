package com.personal;

import com.personal.models.GraphQLRequest;
import com.personal.models.GraphQLResponse;
import com.personal.models.QuasarGraphQLServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import java.util.Iterator;

public class GraphQLGRPCApplicationClientApplication {

    public static void main(String[] args) {

        ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", 8888)
            .enableRetry()
            .usePlaintext()
            .build();

        QuasarGraphQLServiceGrpc.QuasarGraphQLServiceBlockingStub quasarGraphQLService = QuasarGraphQLServiceGrpc.newBlockingStub(channel);

        GraphQLRequest.Builder request = GraphQLRequest.newBuilder().setQuery("query { getWiringInstruction(id: 24) { name, bankName } }");
        Iterator<GraphQLResponse> execute = quasarGraphQLService.execute(request.build());

        while (execute.hasNext()) {
            GraphQLResponse response = execute.next();

            System.out.println("Response: " + response);
        }
    }

}
