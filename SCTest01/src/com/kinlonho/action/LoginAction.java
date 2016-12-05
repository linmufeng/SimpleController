package com.kinlonho.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kinlonho.bean.UserBean;
import com.kinlonho.service.UserService;

/**
 * 
 * @author  kinlonho 
 * @mail    linmufeng@yeah.net
 * @date    2016/12/05 15:15
 * @version 1.2
 * @info    
 *
 */
public class LoginAction {
    
    public Object login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        Object state = null;
        
        // 1.获取请求数据，封装
        String name = req.getParameter("username");
        String psw = req.getParameter("password");
        
        UserBean user = new UserBean();
        user.setUsername(name);
        user.setPassword(psw);
        
        // 2.调用Service
        UserService service = new UserService();
        UserBean userInfo = service.login(user);
        if (userInfo == null){
            //登录失败状态
            state = "fail";
        }else{
            //设置用户信息
            req.getSession().setAttribute("userInfo", userInfo);
            //返回成功状态
            state = "success";
        }
        return state;
        
    }

}
