package com.yuan.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RespInfo {
    private String code;
    private String msg;
    public static RespInfo fail(String code, String defaultMessage) {
        return new RespInfo(code,defaultMessage);
    }
}
