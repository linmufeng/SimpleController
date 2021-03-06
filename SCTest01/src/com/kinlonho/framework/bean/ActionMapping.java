package com.kinlonho.framework.bean;

import java.util.Map;

/**
 * 
 * @author  kinlonho 
 * @mail    linmufeng@yeah.net
 * @date    2016/12/05 13:08
 * @version 1.2
 *
 */

public class ActionMapping {
    private String name;                    //请求路径名称
    private String className;               //处理action路径的类的全名
    private String method;                  //处理method
    private Map<String,Result> results;     //结果视图集合
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }
    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }
    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }
    /**
     * @return the results
     */
    public Map<String, Result> getResults() {
        return results;
    }
    /**
     * @param results the results to set
     */
    public void setResults(Map<String, Result> results) {
        this.results = results;
    }

}
