package com.example.infra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppListener implements ApplicationListener<ApplicationEvent> {

	public AppListener() {
		//public SpringApplication(ResourceLoader resourceLoader, Class... primarySources)
		//this.setListeners(this.getSpringFactoriesInstances(ApplicationListener.class));
		log.info("-------------------AppListener");
	}
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("============================" + event.getClass().getName());
		
	}

}
