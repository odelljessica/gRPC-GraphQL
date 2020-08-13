package com.personal.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GrpcServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);

    private Server server;

    @Autowired
    private QuasarGraphQLServiceGrpcImpl quasarGraphQLServiceGrpcImpl;

    @Autowired
    private AladdinGraphQLServiceGrpcImpl aladdinGraphQLServiceGrpcImpl;

    @PostConstruct
    private void start() throws IOException {
        int port = 8888;

        // StartBuilder starts a gRPC endpoint on port 8888 and Services (like )
        this.server = ServerBuilder.forPort(port)
            .addService(this.quasarGraphQLServiceGrpcImpl)
            .addService(this.aladdinGraphQLServiceGrpcImpl)
            .build().start();
        LOGGER.info("Server started, listening on " + port);
        Runtime.getRuntime()
            .addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
                        GrpcServer.this.stop();
                        LOGGER.error("*** server shut down");
                    }
                });
    }

    private void stop() {
        if (this.server != null) {
            this.server.shutdown();
        }
    }

}
