package com.example.infra;

import com.example.demo.ComponentTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;

/**
 * ComponentTest           : -------------------contructor
 * BeanPostProcessorTest   : -------------------postProcessPropertyValues          ？？？
 * BeanPostProcessorTest   : -------------------postProcessBeforeInitialization
 * ComponentTest           : -------------------init
 * ComponentTest           : -------------------afterPropertiesSet
 * BeanPostProcessorTest   : -------------------postProcessAfterInitialization
 */

//@Component  不在搜索路径，用这个不能实例化，而通过ApplicationInitializer=>BeanFactoryPostProcessor实例化
@Slf4j
public class BeanPostProcessorTest implements InstantiationAwareBeanPostProcessor {

	public BeanPostProcessorTest() {}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ComponentTest) {
			log.info("-------------------postProcessBeforeInitialization");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ComponentTest) {
			log.info("-------------------postProcessAfterInitialization");
		}
		return bean;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
		if (bean instanceof ComponentTest) {
			log.info("-------------------postProcessPropertyValues");
		}

		if (bean.getClass().equals(ComponentTest.class)) {
			ReflectionUtils.doWithLocalFields(ComponentTest.class, (field) -> {
				Value v = field.getAnnotation(Value.class);
				DynamicMyProp d = field.getAnnotation(DynamicMyProp.class);
				if (v != null && d != null) {
					DynamicMyPropRegistry.getInstance().registProp(v.value(), new SpringValue(v.value(), bean, field));
					//log.info(field.getName() + "-----" + field.getAnnotationsByType(DynamicMyProp.class).length);
				}
			});
		}

		return pvs;
	}
}
