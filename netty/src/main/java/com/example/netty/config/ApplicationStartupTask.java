package com.example.netty.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.netty.socket.NettyServerSocket;

@Component
@RequiredArgsConstructor
public class ApplicationStartupTask implements ApplicationListener<ApplicationReadyEvent> {

  private final NettyServerSocket nettyServerSocket;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    nettyServerSocket.start();
  }
}