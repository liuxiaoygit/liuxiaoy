package com.yuan.designPatterns.structure.decorator;

import org.slf4j.Logger;

public class LoggerFactory {

    public static JsonLogger getJsonLogger(Class clazz) {
        Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
        return new JsonLogger(logger);
    }

}
