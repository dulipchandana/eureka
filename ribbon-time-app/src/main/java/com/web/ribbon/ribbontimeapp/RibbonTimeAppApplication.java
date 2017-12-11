package com.web.ribbon.ribbontimeapp;


import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.web.ribbon.config.ribbontimeapp.RibbonTimeConfig;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
//run without eureka only load balansing 
@RibbonClient(name = "time-service" , configuration=RibbonTimeConfig.class)
public class RibbonTimeAppApplication {

	@Inject
	private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}
	
	@GetMapping
	public String getTime() {
		return restTemplate.getForEntity("http://time-service/getTime", String.class).getBody();
		
	}
	
	@Bean
	@LoadBalanced
	//client side load balancing 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
