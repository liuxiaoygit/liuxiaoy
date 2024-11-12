package com.yuan.designPatterns.abstractfactory;

public class Test {

    @org.junit.Test
    public void test_CacheService() throws Exception {
        ICacheAdapter proxy_EGM = JDKProxy.getProxy(EGMCacheAdapter.class, new
                EGMCacheAdapter());
        proxy_EGM.set("user_name_01","⼩傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        ICacheAdapter proxy_IIR = JDKProxy.getProxy(IIRCacheAdapter.class, new
                IIRCacheAdapter());
        proxy_IIR.set("user_name_01","⼩傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }
}
