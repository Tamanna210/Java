package com.example.demo.service;

public class EmailConnection {
	private String ip;
	private int port;

	public EmailConnection(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void sendMessage(String msg) {
		System.out.println("message " + msg + " sent to " + ip + ":" + port);
	}
}
