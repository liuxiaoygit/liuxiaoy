package com.yuan.designPatterns.abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EGM {

    private Map<String, String> dataMap = new HashMap();

    public String gain(String key) {
        System.out.println("BGM获取数据");
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("BGM设置数据");
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("BGM设置数据");
        dataMap.put(key, value);
    }

    public void delete(String key) {
        System.out.println("BGM设置数据");
        dataMap.remove(key);
    }
}
