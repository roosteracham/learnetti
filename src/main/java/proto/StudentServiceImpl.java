package proto;

import io.grpc.stub.StreamObserver;
import proto.*;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getIdByName(HelloRequest request, StreamObserver<HelloRespose> responseObserver) {
        System.out.println(request.getName());
        responseObserver.onNext(getId(request));
        responseObserver.onCompleted();
    }

    private HelloRespose getId(HelloRequest request) {
        return HelloRespose.newBuilder().setId(4).build();
    }

    @Override
    public void getStudentsById(StudentId request, StreamObserver<StudentDo> responseObserver) {
        System.out.println("请求id: " + request.getId());

        responseObserver.onNext(StudentDo.newBuilder().setName("qd1").setAge(20).build());
        responseObserver.onNext(StudentDo.newBuilder().setName("qd2").setAge(30).build());
        responseObserver.onNext(StudentDo.newBuilder().setName("qd3").setAge(40).build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentId> bioTalk(StreamObserver<StudentDo> responseObserver) {
        return new StreamObserver<StudentId>() {
            @Override
            public void onNext(StudentId value) {
                System.out.println("from client:\n" + value.getId());

                StudentDo qd = StudentDo.newBuilder().setAge(30).setName("qd").build();
                responseObserver.onNext(qd);
            }

            @Override
            public void onError(Throwable t) {

                System.out.println("server err");
            }

            @Override
            public void onCompleted() {

                System.out.println("complete");
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StudentId> getStudentsByIds(StreamObserver<StudentDoList> responseObserver) {
        StreamObserver<StudentId> studentIdStreamObserver =
                new StreamObserver<StudentId>() {
                    @Override
                    public void onNext(StudentId value) {
                        System.out.println("from client: \n" + value);
                    }

                    @Override
                    public void onError(Throwable t) {

                        System.out.println("server err");
                    }

                    @Override
                    public void onCompleted() {

                        System.out.println("server onCompleted");
                        StudentDo studentDo = StudentDo.newBuilder().setAge(20).setName("n1").build();
                        StudentDo studentDo2 = StudentDo.newBuilder().setAge(20).setName("n1").build();
                        StudentDoList list = StudentDoList.newBuilder()
                                .addStudent(studentDo).addStudent(studentDo2).build();

                        responseObserver.onNext(list);
                        responseObserver.onCompleted();

                    }
                };
                return studentIdStreamObserver;
    }
}
