package org.example.FirstDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Reactor implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private SelectionKey selectionKey;

    public Reactor() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket socket = serverSocketChannel.socket();
            socket.bind(new InetSocketAddress(8899));
            selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            selectionKey.attach(new Acceptor(selectionKey));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    selectionKey = iterator.next();
                    dispatch();
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch() {
        Runnable attachment = (Runnable) selectionKey.attachment();
        if (attachment != null) {
            attachment.run();
        }
    }

    class Acceptor implements Runnable {
        private SelectionKey selectionKey;
        public Acceptor(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {

                ServerSocketChannel serverSocketChannel =
                        (ServerSocketChannel) this.selectionKey.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel != null) {
                    new Handler(selector, socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Handler implements Runnable{
        private final SocketChannel socketChannel;

        private SelectionKey key;

        private ByteBuffer in = ByteBuffer.allocate(200);

        private ByteBuffer out = ByteBuffer.allocate(200);

        public Handler(Selector selector, SocketChannel socketChannel) throws IOException {

            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            key = this.socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            key.attach(this);
            selector.wakeup();
        }

        @Override
        public void run() {

            if (key.isAcceptable()) {
                try {

                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    socketChannel.configureBlocking(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
