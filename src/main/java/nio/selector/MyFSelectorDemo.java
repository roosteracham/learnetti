package nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class MyFSelectorDemo {

    public static void main(String[] args) throws Exception {

        int[] ports = new int[5];

        for (int i = 0; i < 5; i++) {
            ports[i] = 5000 + i;
        }

        Selector selector = Selector.open();

        for (int i = 0; i < 5; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket socket = serverSocketChannel.socket();
            socket.bind(new InetSocketAddress(ports[i]));

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("开始监听 [" + ports[i] + "] 端口");
        }

        while (true) {
            int select = selector.select();
            System.out.println("select: " + select);

            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel selectableChannel =
                            (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = selectableChannel.accept();
                    channel.configureBlocking(false);

                    channel.register(selector, SelectionKey.OP_READ);

                    iterator.remove();
                } else if (selectionKey.isReadable()) {

                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    int len = 0;
                    ByteBuffer buffer = ByteBuffer.allocate(512);
                    while (true) {
                        buffer.clear();
                        int read = channel.read(buffer);

                        if (read <= 0) {
                            break;
                        }

                        len += read;

                        buffer.flip();

                        int write = channel.write(buffer);

                    }

                    System.out.println("读取长度： " + len);
                    iterator.remove();
                }

            }

        }
    }
}
