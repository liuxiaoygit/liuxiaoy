package com.yuan.designPatterns.create.simplefactory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 实物商品
 */
@Slf4j
public class GoodsCommodityService implements ICommodity{

    static Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        logger.info("这是实物商品");
    }
}
