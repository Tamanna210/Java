package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Value("${ip}")
	private String ip;
	@Value("${port}")
	private int port;
	// factory method
	@Bean
	public EmailConnection getEmailConnection() {
		return new EmailConnection(ip, port);
	}
}
