/**
 * 
 */
package com.web.ribbon.config.ribbontimeapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author dulip
 *
 */
@Configuration
public class RibbonTimeConfig {
	
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}
