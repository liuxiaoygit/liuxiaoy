package com.yuan.exception;

public enum RespCodeEnums {

    BIZ_EXCEPTION("1", "业务异常"),
    PARAMS_NOT_VALID_ERROR("2", "参数校验异常"),
    INNER_SEVER_ERROR("3", "服务异常");
    private String code;
    private String msg;

    RespCodeEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }
}
