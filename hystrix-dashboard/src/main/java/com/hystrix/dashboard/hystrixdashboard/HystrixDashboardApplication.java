package com.hystrix.dashboard.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
	
	//after start got to 
	//http://localhost:8080/hystrix to load the dashboard 
	//then refresh http://localhost:8000/currenet/weather to genarte some statics 
	
	//and add following url as moniterinng url 
	
	//http://localhost:8000/hystrix.stream
	
}
