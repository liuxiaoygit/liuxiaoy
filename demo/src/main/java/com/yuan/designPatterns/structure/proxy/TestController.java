package com.yuan.designPatterns.structure.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class TestController {

    @Autowired
    private ApplicationContext context;

    @GetMapping()
    public void testUserDao() {
        IUserDao bean = context.getBean("userDao",IUserDao.class);
        bean.queryUserInfo("ddd");
    }
}
