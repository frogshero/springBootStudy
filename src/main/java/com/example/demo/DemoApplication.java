package com.example.demo;

import java.util.Map;

import com.example.infra.BeanDefTest;
import com.example.infra.DynamicMyPropRegistry;
import com.example.infra.SpringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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

	@Autowired
	private BeanDefTest beanDefTest;

	@GetMapping("/aa")
	public String getA() {
		// MyProperties prop = getProp();
		//return prop.getBbb() + prop.getCcc() + prop.getDdd() + c.getCustomevalue1();
		return c.getCustomevalue1() + c.getCustomevalue2() + c.getCustomevalue3() + beanDefTest.getTest();
	}


	@GetMapping("/bb")
	public String getB() throws IllegalAccessException {
		for (Map.Entry<String, SpringValue> e : DynamicMyPropRegistry.getInstance().getItems().entries()) {
			SpringValue sv = e.getValue();
			sv.getFld().set(sv.getBean(), sv.getFld().get(sv.getBean()) + "UUUU");
		}
		return "OK";
	}
}
