package com.personal.models;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: graphqlService.proto")
public final class AladdinGraphQLServiceGrpc {

  private AladdinGraphQLServiceGrpc() {}

  public static final String SERVICE_NAME = "AladdinGraphQLService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.personal.models.GraphQLRequest,
      com.personal.models.GraphQLResponse> getExecuteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Execute",
      requestType = com.personal.models.GraphQLRequest.class,
      responseType = com.personal.models.GraphQLResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.personal.models.GraphQLRequest,
      com.personal.models.GraphQLResponse> getExecuteMethod() {
    io.grpc.MethodDescriptor<com.personal.models.GraphQLRequest, com.personal.models.GraphQLResponse> getExecuteMethod;
    if ((getExecuteMethod = AladdinGraphQLServiceGrpc.getExecuteMethod) == null) {
      synchronized (AladdinGraphQLServiceGrpc.class) {
        if ((getExecuteMethod = AladdinGraphQLServiceGrpc.getExecuteMethod) == null) {
          AladdinGraphQLServiceGrpc.getExecuteMethod = getExecuteMethod = 
              io.grpc.MethodDescriptor.<com.personal.models.GraphQLRequest, com.personal.models.GraphQLResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AladdinGraphQLService", "Execute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.personal.models.GraphQLRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.personal.models.GraphQLResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AladdinGraphQLServiceMethodDescriptorSupplier("Execute"))
                  .build();
          }
        }
     }
     return getExecuteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AladdinGraphQLServiceStub newStub(io.grpc.Channel channel) {
    return new AladdinGraphQLServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AladdinGraphQLServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AladdinGraphQLServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AladdinGraphQLServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AladdinGraphQLServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AladdinGraphQLServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void execute(com.personal.models.GraphQLRequest request,
        io.grpc.stub.StreamObserver<com.personal.models.GraphQLResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecuteMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.personal.models.GraphQLRequest,
                com.personal.models.GraphQLResponse>(
                  this, METHODID_EXECUTE)))
          .build();
    }
  }

  /**
   */
  public static final class AladdinGraphQLServiceStub extends io.grpc.stub.AbstractStub<AladdinGraphQLServiceStub> {
    private AladdinGraphQLServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AladdinGraphQLServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AladdinGraphQLServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AladdinGraphQLServiceStub(channel, callOptions);
    }

    /**
     */
    public void execute(com.personal.models.GraphQLRequest request,
        io.grpc.stub.StreamObserver<com.personal.models.GraphQLResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExecuteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AladdinGraphQLServiceBlockingStub extends io.grpc.stub.AbstractStub<AladdinGraphQLServiceBlockingStub> {
    private AladdinGraphQLServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AladdinGraphQLServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AladdinGraphQLServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AladdinGraphQLServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.personal.models.GraphQLResponse> execute(
        com.personal.models.GraphQLRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getExecuteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AladdinGraphQLServiceFutureStub extends io.grpc.stub.AbstractStub<AladdinGraphQLServiceFutureStub> {
    private AladdinGraphQLServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AladdinGraphQLServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AladdinGraphQLServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AladdinGraphQLServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXECUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AladdinGraphQLServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AladdinGraphQLServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE:
          serviceImpl.execute((com.personal.models.GraphQLRequest) request,
              (io.grpc.stub.StreamObserver<com.personal.models.GraphQLResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AladdinGraphQLServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AladdinGraphQLServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.personal.models.GraphQLServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AladdinGraphQLService");
    }
  }

  private static final class AladdinGraphQLServiceFileDescriptorSupplier
      extends AladdinGraphQLServiceBaseDescriptorSupplier {
    AladdinGraphQLServiceFileDescriptorSupplier() {}
  }

  private static final class AladdinGraphQLServiceMethodDescriptorSupplier
      extends AladdinGraphQLServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AladdinGraphQLServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AladdinGraphQLServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AladdinGraphQLServiceFileDescriptorSupplier())
              .addMethod(getExecuteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
