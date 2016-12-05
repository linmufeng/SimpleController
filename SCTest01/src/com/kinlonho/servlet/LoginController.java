package com.kinlonho.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kinlonho.framework.bean.ActionMapping;
import com.kinlonho.framework.bean.ActionMappingManage;
import com.kinlonho.framework.bean.Result;
import com.sun.org.apache.xml.internal.security.Init;
/**
 * 
 * @author  kinlonho 
 * @mail    linmufeng@yeah.net
 * @date    2016/12/05 13:01
 * @version 1.2
 * @info    Servlet implementation class LoginController
 *
 */
//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionMappingManage actionMappingManage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }
    
    public void init(){
        System.out.println("LoginController init");
        actionMappingManage = new ActionMappingManage();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		    //[1]获取请求的actionName
		    //[1.1]获取请求uri
		    String uri = req.getRequestURI();
		    //[1.2]得到请求路径名称，如login
		    String actionName = uri.substring(uri.lastIndexOf("/")+1, uri.indexOf(".scaction"));
		    System.out.println("ActionName is " + actionName);
		    
		    //[2]根据actionName读取配置文件
		    ActionMapping actionMapping = actionMappingManage.getActionMapping(actionName);
		    String className = actionMapping.getClassName();
		    String method = actionMapping.getMethod();
		    
		    // 3.反射 创建对象 调用方法 获取方法返回的标记
		    Class<?> clazz = Class.forName(className);
		    Object ob = clazz.newInstance();
		    Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
		    // 3.x 返回登录状态结果
		    String loginState = m.invoke(ob, req, resp).toString();
		    
		    
		    // 4. 用该状态，读取配置文件对应的页面和类型
		    Result result = actionMapping.getResults().get(loginState);
		    String type = result.getType();       //类型
		    String page = result.getValue();     //页面
		    
		    // 5.跳转页面
		    if ("redirect".equals(type)){
		        resp.sendRedirect(req.getContextPath() + "/" + page);
		    }else{
		        req.getRequestDispatcher(page).forward(req, resp);
		    }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
