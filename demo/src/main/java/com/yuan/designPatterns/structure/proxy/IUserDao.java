package com.yuan.designPatterns.structure.proxy;


import com.yuan.designPatterns.structure.proxy.agent.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
