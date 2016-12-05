package com.kinlonho.dao;

import com.kinlonho.bean.UserBean;

public class UserDao {
    
    //模拟登录
    public UserBean login(UserBean user){
        if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())){
            //登录成功
            return user;
        }
        //登录失败
        return null;
    }
    
    //模拟注册
    public void register(UserBean user){
        System.out.println("注册成功：" + user.getUsername());
    }

}
