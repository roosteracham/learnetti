package org.example.nio.selector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySelectorClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);


        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();

                        ByteBuffer buffer = ByteBuffer.allocate(512);
                        buffer.put("from client connected".getBytes());
                        buffer.flip();
                        channel.write(buffer);

                        ExecutorService executorService = Executors.newSingleThreadExecutor();
                        executorService.submit(() -> {
                            while (true) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                                String line = bufferedReader.readLine();
                                buffer.clear();
                                buffer.put(("msg : " + line).getBytes());
                                buffer.flip();

                                channel.write(buffer);
                            }
                        });

                        channel.register(selector, SelectionKey.OP_READ);
                    }
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(512);

                    int read = channel.read(buffer);
                    if (read > 0) {
                        System.out.println("from server: " + new String(buffer.array(), 0, read));
                    }
                }
                iterator.remove();
            }
        }
    }
}
