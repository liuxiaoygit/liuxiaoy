package com.yuan.designPatterns.create.simplefactory;

import java.util.Map;

/**
 * 商品奖励发放接口
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
