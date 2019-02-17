package com.example.demo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public AppContextInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		MutablePropertySources sources = applicationContext.getEnvironment().getPropertySources();
		try {
		    ResourcePropertySource props = new ResourcePropertySource("MY_PROPS", "classpath:my.properties");
			sources.addFirst(props);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
