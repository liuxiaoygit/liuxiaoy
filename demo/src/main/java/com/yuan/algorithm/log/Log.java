package com.yuan.algorithm.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
//static final Logger LOGGER = Logger.getLogger(Log4J.class);

    //static final Logger LOGGER = LoggerFactory.getLogger(Log4J.class);

    static final Logger LOGGER =  LoggerFactory.getLogger(Log.class);

    public static void main(String[] args) {
        LOGGER.info("this is log4j ");
        //log.info("this is {}", " slf4j log");
    }
}
