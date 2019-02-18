package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
        Matcher m = pattern.matcher("xxa${ewf}axx");
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
