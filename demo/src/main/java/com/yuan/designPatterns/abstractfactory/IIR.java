package com.yuan.designPatterns.abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IIR {

    private Map<String, String> dataMap = new HashMap();

    public String get(String key) {
        System.out.println("IIR获取数据");
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("IIR设置数据");
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("IIR设置数据");
        dataMap.put(key, value);
    }

    public void del(String key) {
        System.out.println("IIR设置数据");
        dataMap.remove(key);
    }
}
