package n.hb;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.UUID;

public class MyHBServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent)evt;

            switch (event.state()) {
                case ALL_IDLE:
                    System.out.println("读写空闲");
                    break;
                case WRITER_IDLE:
                    System.out.println("写空闲");
                    break;
                case READER_IDLE:
                    System.out.println("读空闲");
                    break;

            }
            ctx.channel().close();
        }
    }
}
