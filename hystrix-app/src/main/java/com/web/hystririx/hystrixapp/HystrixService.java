/**
 * 
 */
package com.web.hystririx.hystrixapp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author dulip
 *
 */
@Service
public class HystrixService {

	@Inject
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "unknown")
	public String getWeather() {
		return restTemplate.getForEntity("http://time-service/weather", String.class).getBody();

	}

	public String unknown() {
		return "unknown";
	}

}
