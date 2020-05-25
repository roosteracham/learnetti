package org.example.zerocopy.zero;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewClient {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9000));

        File file = new File("D:\\IDMDownload\\CamtasiaInstaller.exe");
        FileChannel fileChannel = new FileInputStream(
                file).getChannel();
//       fileChannel
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        socketChannel.close();
    }
}
