package com.example.infra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
public class SpringValue {
    private String valueStr;

    private Object bean;

    private Field fld;
}
