package com.example.demo;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@SpringBootApplication
@RestController
@EnableConfigurationProperties(MyProperties.class)
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ComponentTest c;
	
	@Autowired
	private MyProperties prop;

	@GetMapping("/aa")
	public String getA() {
		// MyProperties prop = getProp();
		return prop.getBbb() + prop.getCcc() + prop.getDdd() + c.getCustomevalue1();
	}


}
