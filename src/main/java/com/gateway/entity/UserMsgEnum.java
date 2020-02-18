package com.gateway.entity;

/**
 * @author z
 */

public enum UserMsgEnum {
    SUCCESS("登录成功"),
    WRONG_USERNAME_OR_PASSWORD("用户名或者密码错误"),
    USER_IS_NOT_EXISTS("用户不存在"),
    OTHERS("其他错误");

    String var;

    private UserMsgEnum(String var){
        this.var=var;
    }

    public String getVar(){
        return this.var;
    }

}
