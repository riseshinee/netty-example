package com.example.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDecoder extends ByteToMessageDecoder {
  private int DATA_LENGTH = 2048;

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    System.out.println(in);
    System.out.println(ctx);

    if (in.readableBytes() < DATA_LENGTH) {
      return;
    }

    out.add(in.readBytes(DATA_LENGTH));
  }
}