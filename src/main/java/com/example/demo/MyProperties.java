package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix="aaa")
@Getter
@Setter
public class MyProperties {

	private String bbb;
	private String ccc;
	private String ddd;
}
