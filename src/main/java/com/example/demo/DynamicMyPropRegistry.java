package com.example.demo;


import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class DynamicMyPropRegistry {

    private static DynamicMyPropRegistry registry = new DynamicMyPropRegistry();

    private Multimap<String, SpringValue> items = LinkedListMultimap.create();

    Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
//
//    private String getExpr(String value) {
//
//    }

    public static DynamicMyPropRegistry getInstance() {
        return registry;
    }

    public void registProp(String value, SpringValue item) {
        Matcher m = pattern.matcher(value);
        if (m.find()) {
            items.put(value, item);
        }
    }
}


