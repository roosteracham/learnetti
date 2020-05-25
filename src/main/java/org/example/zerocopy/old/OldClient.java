package org.example.zerocopy.old;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class OldClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);

        InputStream inputStream = new FileInputStream(new File("D:\\IDMDownload\\CamtasiaInstaller.exe"));
//        DataInputStream dataInputStream = new DataInputStream(
//                new FileInputStream("D:\\IDMDownload\\CamtasiaInstaller.exe"));

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[4096];
        int read = 0;
        while ((read = inputStream.read(buffer, 0, buffer.length)) <= 0) {
            dataOutputStream.write(buffer, 0, read);
        }

        socket.close();
    }
}
