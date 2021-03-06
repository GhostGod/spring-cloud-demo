package org.liuyang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String hello() {
		return restTemplate.getForEntity("http://cloud-client/hello", String.class).getBody();
	}

	public String fallback() {
		return "error";
	}
}
