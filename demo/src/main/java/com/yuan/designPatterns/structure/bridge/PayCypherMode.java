package com.yuan.designPatterns.structure.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  密码支付
 */
public class PayCypherMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(PayCypherMode.class);

    public boolean security(String uId) {
        logger.info("密码⽀付，⻛控校验环境安全");
        return true;
    }
}