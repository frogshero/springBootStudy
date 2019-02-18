package com.example.infra;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import lombok.extern.slf4j.Slf4j;

/**
 * initialize:21, AppContextInitializer (com.example.demo)
 * applyInitializers:633, SpringApplication (org.springframework.boot)
 * prepareContext:373, SpringApplication (org.springframework.boot)
 * run:325, SpringApplication (org.springframework.boot)
 * run:1255, SpringApplication (org.springframework.boot)
 * run:1243, SpringApplication (org.springframework.boot)
 * main:30, DemoApplication (com.example.demo)
 */

@Slf4j
public class AppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public AppContextInitializer() {
		//public SpringApplication(ResourceLoader resourceLoader, Class... primarySources)
		//this.setInitializers(this.getSpringFactoriesInstances(ApplicationContextInitializer.class));
		log.info("-------------------AppContextInitializer");
	}

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		log.info("-------------------initialize");
		MutablePropertySources sources = applicationContext.getEnvironment().getPropertySources();
		try {
		    ResourcePropertySource props = new ResourcePropertySource("MY_PROPS", "classpath:my.properties");
			sources.addFirst(props);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		/////
		applicationContext.addBeanFactoryPostProcessor(new BeanFactoryProcessorTest());
	}

}
