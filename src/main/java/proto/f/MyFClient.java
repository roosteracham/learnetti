package proto.f;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.*;

import java.util.Iterator;

public class MyFClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8899).usePlaintext().build();

        StudentServiceGrpc.StudentServiceBlockingStub stub =
                StudentServiceGrpc.newBlockingStub(managedChannel);

        HelloRespose quandan = stub.getIdByName(HelloRequest.newBuilder().setName("quandan").build());

        System.out.println(quandan.getId());
        System.out.println("=============");

        Iterator<StudentDo> students = stub.getStudentsById(StudentId.newBuilder().setId(1).build());
        while (students.hasNext()) {
            StudentDo next = students.next();
            System.out.println(next.toString());
        }
    }
}
