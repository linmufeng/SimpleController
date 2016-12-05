package com.kinlonho.framework.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author  kinlonho 
 * @mail    linmufeng@yeah.net
 * @date    2016/12/05 13:01
 * @version 1.2
 * @info    load controller.xml and resolve
 */

public class ActionMappingManage {
    //保存action的集合
    private Map<String, ActionMapping> allActions;
    
    public ActionMappingManage(){
        allActions = new HashMap<String,ActionMapping>();
        this.init();
    }

    /**
     * @param actionName    当前请求路径
     * @return              配置文件中代表action的actionMapping对象
     */
    public ActionMapping getActionMapping (String actionName){
        if (actionName == null){
            throw new RuntimeException("ActionName is null");
        }
        ActionMapping actionMapping = allActions.get(actionName);
        if (actionMapping == null){
            throw new RuntimeException("ActionName is not exist");
        }
        return actionMapping;
    }
    
    
    private void init() {
        /*************DOM4J读取配置文件************/
        try {
            // 1.得到解析器,得到src/controller.xml文件流
            SAXReader reader = new SAXReader();
            InputStream inStream = this.getClass().getResourceAsStream("/controller.xml");
            
            // 2.加载文件
            Document document = reader.read(inStream);
            
            // 3.获取文档的根节点.  
            Element root = document.getRootElement();
            
            // 4.取得根节点下的所有action子节点
            List<Element> listAction = root.elements("action");
            
            // 5.遍历 封装
            for(Element ele_action : listAction){
                // 5.1 封装一个ActionMapping对象
                ActionMapping actionMapping = new ActionMapping();
                
                // 5.2 封装当前action结点下的action_name class_name class_method视图,类名
                Element ele_name = ele_action.element("name");
                actionMapping.setName(ele_name.getText());
                
                Element ele_class = ele_action.element("class");
                actionMapping.setClassName(ele_class.element("name").getText());
                actionMapping.setMethod(ele_class.element("method").getText());
                
                // 5.3封装当前action下的所有result视图
                Map<String, Result> results = new HashMap<String, Result>();

                // 5.4得到当前action节点下所有的result子节点                
                Iterator<Element> it = ele_action.elementIterator("result");
                
                while(it.hasNext()){
                    // 当前迭代的每一个元素都是<result...>
                    Element ele_result = it.next();
                    
                    // 封装对象
                    Result res = new Result();
                    res.setName(ele_result.element("name").getText());
                    res.setType(ele_result.element("type").getText());
                    res.setValue(ele_result.element("value").getText());
                    
                    //添加到集合中
                    results.put(res.getName(), res);
                }
                
                //设置到actionMapping中
                actionMapping.setResults(results);
                
                //actionMapping添加到allAction集合中
                allActions.put(actionMapping.getName(), actionMapping);
                
                
            }
            
        } catch (Exception e) {
            throw new RuntimeException("启动时初始化错误:",e);
        }
    }

}
