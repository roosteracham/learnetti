package org.example.proto.n.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitialier());

            Channel future = bootstrap.connect("localhost", 8899).channel();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                future.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
