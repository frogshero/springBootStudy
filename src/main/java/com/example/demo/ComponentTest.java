package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Getter
public class ComponentTest implements InitializingBean {

	public ComponentTest() {
		log.info("-------------------contructor");
	}

	@DynamicMyProp
	@Value("${customevalue1}")
	private String customevalue1;

	@DynamicMyProp
	@Value("${customevalue2}")
	private String customevalue2;

	@DynamicMyProp
	@Value("${customevalue3}")
	private String customevalue3;

	@PostConstruct
	public void init() {
		log.info("-------------------init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("-------------------afterPropertiesSet");
		
	}

}
