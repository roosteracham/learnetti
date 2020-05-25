package org.example.proto.n.f;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        System.out.println("TestServerInitializer initChannel");
        pipeline.addLast("hsc", new HttpServerCodec());
        pipeline.addLast("msh", new MyHttpServerHandler());
    }
}
