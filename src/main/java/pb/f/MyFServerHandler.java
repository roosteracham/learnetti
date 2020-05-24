package pb.f;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyFServerHandler extends SimpleChannelInboundHandler<AddressBookProtos.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtos.Person msg) throws Exception {

        System.out.println(msg);
        ctx.channel().writeAndFlush(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
