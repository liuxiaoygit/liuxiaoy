package com.yuan.designPatterns.create.simplefactory;

public class Test {
    public static void main(String[] args) throws Exception {
        StoreFactory factory = new StoreFactory();
        ICommodity commodityService = factory.getCommodityService(1);
        commodityService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
    }
}
