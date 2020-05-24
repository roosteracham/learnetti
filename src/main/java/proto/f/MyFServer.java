package proto.f;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import proto.StudentServiceImpl;

import java.io.IOException;

public class MyFServer {

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runtime shutdown");
            }
        }));
        System.out.println("start");
    }

    private void stop() throws InterruptedException {

        if (null != server) {
            server.shutdown();
        }

    }

    private void awaitTerminate() throws InterruptedException {
        if (null != server) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        MyFServer myFServer = new MyFServer();
        myFServer.start();
        myFServer.awaitTerminate();
    }
}
