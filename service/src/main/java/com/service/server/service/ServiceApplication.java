package com.service.server.service;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//run without eureka service discovery 
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceApplication {

	@Value("${service.instance.name}")
	private String instance;

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String message() {
		return "Message From -- " + instance;
	}

	@GetMapping("/getTime")
	public String getTime() {

		return "current-server-time-" + new Date().toGMTString() + "(responce from " + port + ")";

	}

	private String[] weather = new String[] { "sunny", "cloudy", "rainy", "windy" };

	@GetMapping("/weather")
	public String getWeather() {
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[rand];

	}
}
