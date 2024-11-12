package com.yuan.designPatterns.structure.decorator;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

public class JsonLogger extends LoggerDecorator {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", s);
        logger.info(jsonObject.toJSONString());
    }

    @Override
    public void error(String s) {
        super.error(s);
    }
}
