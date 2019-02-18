package com.example.infra;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;

/**
 * postProcessBeanDefinitionRegistry:14, BeanFactoryProcessorTest (com.example.infra)
 * invokeBeanFactoryPostProcessors:68, PostProcessorRegistrationDelegate (org.springframework.context.support)
 * invokeBeanFactoryPostProcessors:694, AbstractApplicationContext (org.springframework.context.support)
 * refresh:532, AbstractApplicationContext (org.springframework.context.support)
 * refresh:140, ServletWebServerApplicationContext (org.springframework.boot.web.servlet.context)
 * refresh:759, SpringApplication (org.springframework.boot)
 * refreshContext:395, SpringApplication (org.springframework.boot)
 * run:327, SpringApplication (org.springframework.boot)
 */
public class BeanFactoryProcessorTest implements BeanDefinitionRegistryPostProcessor {

    private static final String BEAN_NAME = "beanPostProcessorTest";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        if (beanDefinitionRegistry.containsBeanDefinition(BEAN_NAME)) {
            return;
        }
        BeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition(BeanPostProcessorTest.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition(BEAN_NAME, bd);

        RootBeanDefinition gbd = new RootBeanDefinition(BeanDefTest.class);
        beanDefinitionRegistry.registerBeanDefinition("beanDefTest", gbd);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
