package com.kinlonho.framework.bean;

/**
 * 
 * @author  kinlonho 
 * @mail    linmufeng@yeah.net
 * @date    2016/12/05 13:01
 * @version 1.2
 *
 */

public class Result {
    // 跳转结果标记
    private String name;
    
    // 跳转类型，默认转发；"redirect"为重定向
    private String type;
    
    // 跳转页面
    private String value;

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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
