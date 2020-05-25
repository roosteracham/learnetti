package org.example.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySelectorServer {

    private static Set<SocketChannel> socketChannels = new HashSet<>();

    public static void main(String[] args) throws Exception{
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8899));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    SocketChannel socket1 = serverSocketChannel1.accept();
                    socket1.configureBlocking(false);
                    socket1.register(selector, SelectionKey.OP_READ);
                    socketChannels.add(socket1);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(512);

                    int read = channel.read(buffer);
                    if (read > 0) {
                        buffer.flip();
                        Charset charset = Charset.forName("utf-8");
                        char[] array = charset.decode(buffer).array(); // decode和encode方法会flip之后返回新的对象；
                        System.out.println(String.valueOf(array));

                        socketChannels.forEach(socketChannel -> {
                            try {
                                buffer.flip();
                                socketChannel.write(buffer);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                    }

                }
                iterator.remove();
            }
        }
    }
}
