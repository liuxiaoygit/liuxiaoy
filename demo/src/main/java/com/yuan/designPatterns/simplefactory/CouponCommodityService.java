package com.yuan.designPatterns.simplefactory;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 *  优惠券奖品
 */
@Slf4j
public class CouponCommodityService  implements ICommodity{
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        log.info("这是优惠券奖品");
    }
}
