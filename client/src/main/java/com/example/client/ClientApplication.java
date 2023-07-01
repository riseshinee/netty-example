package com.example.client;

import com.example.client.sockets.NonSslSocket;

import java.util.Scanner;

public class ClientApplication {

	public static void main(String[] args) throws InterruptedException {
		String host = "127.0.0.1";
		int port = 8888;
		try {
			System.out.println("Enter message length: ");
			try (Scanner sc = new Scanner(System.in)) {
				int messageLength = Integer.parseInt(sc.nextLine());

				NonSslSocket socket = new NonSslSocket(host, port);
				socket.run(messageLength);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}