package org.example.proto;

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
    value = "by gRPC org.example.proto compiler (version 1.21.0)",
    comments = "Source: Student.org.example.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.proto.StudentService";

  // Static method descriptors that strictly reflect the org.example.proto.
  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloRespose> getGetIdByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIdByName",
      requestType = HelloRequest.class,
      responseType = HelloRespose.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloRespose> getGetIdByNameMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloRespose> getGetIdByNameMethod;
    if ((getGetIdByNameMethod = StudentServiceGrpc.getGetIdByNameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetIdByNameMethod = StudentServiceGrpc.getGetIdByNameMethod) == null) {
          StudentServiceGrpc.getGetIdByNameMethod = getGetIdByNameMethod = 
              io.grpc.MethodDescriptor.<HelloRequest, HelloRespose>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.StudentService", "GetIdByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRespose.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetIdByName"))
                  .build();
          }
        }
     }
     return getGetIdByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentId,
      StudentDo> getGetStudentsByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsById",
      requestType = StudentId.class,
      responseType = StudentDo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<StudentId,
      StudentDo> getGetStudentsByIdMethod() {
    io.grpc.MethodDescriptor<StudentId, StudentDo> getGetStudentsByIdMethod;
    if ((getGetStudentsByIdMethod = StudentServiceGrpc.getGetStudentsByIdMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsByIdMethod = StudentServiceGrpc.getGetStudentsByIdMethod) == null) {
          StudentServiceGrpc.getGetStudentsByIdMethod = getGetStudentsByIdMethod = 
              io.grpc.MethodDescriptor.<StudentId, StudentDo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.StudentService", "GetStudentsById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentDo.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentsById"))
                  .build();
          }
        }
     }
     return getGetStudentsByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentId,
      StudentDoList> getGetStudentsByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByIds",
      requestType = StudentId.class,
      responseType = StudentDoList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<StudentId,
      StudentDoList> getGetStudentsByIdsMethod() {
    io.grpc.MethodDescriptor<StudentId, StudentDoList> getGetStudentsByIdsMethod;
    if ((getGetStudentsByIdsMethod = StudentServiceGrpc.getGetStudentsByIdsMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsByIdsMethod = StudentServiceGrpc.getGetStudentsByIdsMethod) == null) {
          StudentServiceGrpc.getGetStudentsByIdsMethod = getGetStudentsByIdsMethod = 
              io.grpc.MethodDescriptor.<StudentId, StudentDoList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.StudentService", "GetStudentsByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentDoList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentsByIds"))
                  .build();
          }
        }
     }
     return getGetStudentsByIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentId,
      StudentDo> getBioTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BioTalk",
      requestType = StudentId.class,
      responseType = StudentDo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<StudentId,
      StudentDo> getBioTalkMethod() {
    io.grpc.MethodDescriptor<StudentId, StudentDo> getBioTalkMethod;
    if ((getBioTalkMethod = StudentServiceGrpc.getBioTalkMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBioTalkMethod = StudentServiceGrpc.getBioTalkMethod) == null) {
          StudentServiceGrpc.getBioTalkMethod = getBioTalkMethod = 
              io.grpc.MethodDescriptor.<StudentId, StudentDo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.StudentService", "BioTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentDo.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("BioTalk"))
                  .build();
          }
        }
     }
     return getBioTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getIdByName(HelloRequest request,
                            io.grpc.stub.StreamObserver<HelloRespose> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIdByNameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentsById(StudentId request,
                                io.grpc.stub.StreamObserver<StudentDo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByIdMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentId> getStudentsByIds(
        io.grpc.stub.StreamObserver<StudentDoList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsByIdsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentId> bioTalk(
        io.grpc.stub.StreamObserver<StudentDo> responseObserver) {
      return asyncUnimplementedStreamingCall(getBioTalkMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetIdByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                HelloRequest,
                HelloRespose>(
                  this, METHODID_GET_ID_BY_NAME)))
          .addMethod(
            getGetStudentsByIdMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                StudentId,
                StudentDo>(
                  this, METHODID_GET_STUDENTS_BY_ID)))
          .addMethod(
            getGetStudentsByIdsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                StudentId,
                StudentDoList>(
                  this, METHODID_GET_STUDENTS_BY_IDS)))
          .addMethod(
            getBioTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                StudentId,
                StudentDo>(
                  this, METHODID_BIO_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getIdByName(HelloRequest request,
                            io.grpc.stub.StreamObserver<HelloRespose> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIdByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsById(StudentId request,
                                io.grpc.stub.StreamObserver<StudentDo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentId> getStudentsByIds(
        io.grpc.stub.StreamObserver<StudentDoList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsByIdsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentId> bioTalk(
        io.grpc.stub.StreamObserver<StudentDo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBioTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public HelloRespose getIdByName(HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIdByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<StudentDo> getStudentsById(
        StudentId request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloRespose> getIdByName(
        HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIdByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ID_BY_NAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_ID = 1;
  private static final int METHODID_GET_STUDENTS_BY_IDS = 2;
  private static final int METHODID_BIO_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ID_BY_NAME:
          serviceImpl.getIdByName((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloRespose>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_ID:
          serviceImpl.getStudentsById((StudentId) request,
              (io.grpc.stub.StreamObserver<StudentDo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENTS_BY_IDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsByIds(
              (io.grpc.stub.StreamObserver<StudentDoList>) responseObserver);
        case METHODID_BIO_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bioTalk(
              (io.grpc.stub.StreamObserver<StudentDo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Student.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetIdByNameMethod())
              .addMethod(getGetStudentsByIdMethod())
              .addMethod(getGetStudentsByIdsMethod())
              .addMethod(getBioTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
