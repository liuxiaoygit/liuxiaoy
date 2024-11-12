package com.yuan.designPatterns.create.simplefactory;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}