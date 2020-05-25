package org.example.zerocopy.old;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket socket = serverSocket.accept();
            long start = System.currentTimeMillis();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte[] buffer = new byte[4096];
            int read = 0;
            while ((read = dataInputStream.read(buffer, 0, buffer.length)) != -1) {

            }

            System.out.println("耗时：: " + String.valueOf(System.currentTimeMillis() - start));
        }
    }
}
