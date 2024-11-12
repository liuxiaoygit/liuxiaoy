package com.yuan.designPatterns.structure.bridge;

import java.math.BigDecimal;

/**
 * 针对抽象和具体类都会扩展
 * 支付宝和微信支付 都支持人脸和密码支付
 */
public class Test {

    @org.junit.Test
    public void test() {
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
    }
}
