package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {
	
	@Value("${configuration.property}")
	private String configProperty;
	
	@GetMapping("/getConfigProperty")
	public String getConfigProperty() {
		return configProperty;
	}
}
