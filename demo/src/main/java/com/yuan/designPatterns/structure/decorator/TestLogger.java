package com.yuan.designPatterns.structure.decorator;

import org.slf4j.Logger;

/**
 * 装饰器模式，用聚合代替继承
 */
public class TestLogger {

    private static  final Logger logger = LoggerFactory.getJsonLogger(TestLogger.class);

    public static void main(String[] args) {
        logger.info("发送成功");
    }
}
