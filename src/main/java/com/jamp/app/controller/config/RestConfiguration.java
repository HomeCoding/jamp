package com.jamp.app.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@Configuration
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class RestConfiguration {
	
//	@Bean
//	public Filter shallowEtagHeaderFilter() {
//	      // Note this filter does not improve application performance, as it requires the request to be fully processed to generate the ETag
//	      // It only saves bandwidth
//		return new ShallowEtagHeaderFilter();
//	}
//	
//	@Bean
//	@Autowired
//	public FilterRegistrationBean corsFilterRegistrationBean() {
//		
//	}
}
