package org.example.proto.arar;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.proto.StudentDo;
import org.example.proto.StudentId;
import org.example.proto.StudentServiceGrpc;

public class MyARARClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceStub studentServiceStub =
                StudentServiceGrpc.newStub(channel);

        StreamObserver<StudentId> studentIdStreamObserver =
                studentServiceStub.bioTalk(new StreamObserver<StudentDo>() {
            @Override
            public void onNext(StudentDo value) {

                System.out.println("from server" + value);
            }

            @Override
            public void onError(Throwable t) {

                System.out.println("cli err");
            }

            @Override
            public void onCompleted() {

                System.out.println("cli com");
            }
        });

        for (int i = 1; i < 10; i++) {

            studentIdStreamObserver.onNext(StudentId.newBuilder().setId(i).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        studentIdStreamObserver.onCompleted();

    }
}
