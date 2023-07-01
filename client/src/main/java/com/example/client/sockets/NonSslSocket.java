package com.example.client.sockets;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@AllArgsConstructor
// 목적지에 해당하는 소켓을 연결하는 곳
public class NonSslSocket {
  private String host;
  private int port;

  public void run(int messageLength) {
    try {
      Socket socket = new Socket();
      SocketAddress address = new InetSocketAddress(host, port);
      socket.connect(address);

      ClientSocket clientSocket = new ClientSocket(socket);
      clientSocket.sendFixedLength(messageLength);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}