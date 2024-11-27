package com.yuan.exception;


import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
public class User extends Pserson {
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度在 min ~ max 之间")
    private String password;
 
    @NotNull(message = "id不能为空")
    @NotBlank(message = "id不能为空")
    private int id;
 
    @NotBlank(message = "姓名不能为空")
    @Size(min = 2, max = 8, message = "username 长度在 min ~ max 之间")
    private String username;
 
    private int age;

    public User() {
        super();
        System.out.println("user 无参构造函数");
    }

    public static void main(String[] args) {
        User user = new User();
        user.setNameEn("nameEn");
        System.out.println("user" + user.getNameEn());
    }
}