package com.ew.roc.model;


public class User {

    public long birthday;//生日 1970时间
    public String email ;
    public String icon ;
    public String id ;//账户内部id
    public String nick;//昵称
    public String qq;
    public long regtime;//注册时间 1970时间
    public int sex ;//sex 0 标示女  1标示男
    public String sign ;//签名
    public String token ;//session id
    public int type ;//账户类型:0 标示正常账户 1 标示新浪微博账户 2 标示qq账户 3 标示微信账户
    public String website;


}
