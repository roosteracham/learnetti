package org.example.proto.arsr;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.proto.StudentDoList;
import org.example.proto.StudentId;
import org.example.proto.StudentServiceGrpc;

public class MyARSRClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(channel);

        StreamObserver<StudentDoList> responseObserver = new StreamObserver<StudentDoList>() {
            @Override
            public void onNext(StudentDoList value) {
                value.getStudentList().forEach(student -> {
                    System.out.println("from server:\n" + student);
                });
            }

            @Override
            public void onError(Throwable t) {

                System.out.println("client error");
            }

            @Override
            public void onCompleted() {

                System.out.println("end");
            }
        };
        StreamObserver<StudentId> students = studentServiceStub.getStudentsByIds(responseObserver);

        students.onNext(StudentId.newBuilder().setId(1).build());
        students.onNext(StudentId.newBuilder().setId(2).build());
        students.onNext(StudentId.newBuilder().setId(3).build());
        students.onNext(StudentId.newBuilder().setId(4).build());

        Thread.sleep(10000);
        students.onCompleted();
    }
}
