package pb.f;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

public class MyFClientHandler extends SimpleChannelInboundHandler<AddressBookProtos.Person> {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active");
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setEmail("abc@123.com").setId(1).setName("quanDan").build();
        ctx.writeAndFlush(person);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtos.Person msg) throws Exception {
        System.out.println(msg);

    }
}
