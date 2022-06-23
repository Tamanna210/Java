package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.service.AppService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		AppService service = ctx.getBean("appService", AppService.class);
//		AppService service = (AppService) ctx.getBean("appService");
		
		service.doTask();
	}

}
