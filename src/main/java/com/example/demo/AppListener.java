package com.example.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AppListener implements ApplicationListener<ApplicationEvent> {

	//org.springframework.context.ApplicationListener=com.example.demo.AppListener
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("============================" + event.getClass().getName());
		
	}

}
