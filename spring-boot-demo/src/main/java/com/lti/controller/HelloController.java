package com.lti.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello.lti")
	public String hello() {
		return "welcome to Spring API Development using Spring Boot";
	}

}
