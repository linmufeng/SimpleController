package com.kinlonho.service;

import com.kinlonho.bean.UserBean;
import com.kinlonho.dao.UserDao;

public class UserService {
    private UserDao ud = new UserDao();
 
    // 模拟登录 
    public UserBean login (UserBean user){
        return ud.login(user);
    }

    // 模拟注册
    public void register (UserBean user){
        ud.register(user);
    }

}
