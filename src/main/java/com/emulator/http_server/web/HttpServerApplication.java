package com.emulator.http_server.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class HttpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpServerApplication.class, args);
	}

}
