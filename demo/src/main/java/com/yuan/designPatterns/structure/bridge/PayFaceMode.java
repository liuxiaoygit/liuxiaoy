package com.yuan.designPatterns.structure.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFaceMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(PayCypherMode.class);

    public boolean security(String uId) {
        logger.info("⼈脸⽀付，⻛控校验脸部识别");
        return true;
    }
}