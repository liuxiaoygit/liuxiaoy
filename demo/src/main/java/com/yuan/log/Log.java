package com.yuan.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
//static final Logger LOGGER = Logger.getLogger(Log4J.class);

    //static final Logger LOGGER = LoggerFactory.getLogger(Log4J.class);

    static final Logger logger =  LoggerFactory.getLogger(Log.class);

    public static void main(String[] args) {
        logger.info("this is slf4j ");
        String data = "日志级别为：";
        logger.error("{}error",data);
        logger.warn("{}warn",data);
        logger.info("{}info",data);
        logger.debug("{}debug",data);
        logger.trace("{}trace",data);
        //log.info("this is {}", " slf4j log");
    }
}
