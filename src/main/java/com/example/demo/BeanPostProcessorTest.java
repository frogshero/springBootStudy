package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessorTest implements BeanPostProcessor {

	public BeanPostProcessorTest() {}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ComponentTest) {
			log.info("----------------------------postProcessBeforeInitialization");
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ComponentTest) {
			log.info("-----------------------------postProcessAfterInitialization");
		}
		return bean;
	}
}
