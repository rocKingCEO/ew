package com.ew.roc.model;

/**
 * Created by WangYuPeng on 9/5/15.
 */
public class LoginRequest  {
    /**
     * 电子邮箱
     */
    public String email = "rocEmail@163.com";
    /**
     * md5密码
     */
    public String pw;
    /**
     * 账户类型:0 标示正常账户 1 标示新浪微博账户 2 标示qq账户 3 标示微信账户
     */
    public String type;
    /**
     * 设备token，推送需要, 可不传
     */
    public String token;



}
