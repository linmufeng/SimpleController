# SimpleController

# 2016/12/04 update

J2EE Project

# 2016/12/05 update

**要求**
> 1)将E1中编写的Servlet子类LoginController，在web.xml 中的配置修改为:可以拦截“*.scaction”类型的请求

> 2)增加controller.xml配置文件

> 3)使用LoginController 进行 request 拦截，解析请求，获取请求的 action。

> 4)LoginController 获取请求 action 后，解析 controller.xml(XML 解析，SAX、Dom 或其他)，查找对应 name 的 action。 如果在 controller.xml 中找到，则解析该 action 的配置，包括 class、result。如果没有找到，响应客户端信息为:不可识别的 action 请求。

> 5)LoginController 查找到 http request 请求的 action 资源 后，利用其 class 属性实例化所指向的 action class(Java 反射机 制，Reflection)，并执行指定的方法 action method。

> 6)action method 执行完毕后，返回字符串作为 result。 LoginController 根据该 action 配置的 result，查找匹配，将 result 指向的资源按 result type 所指定的方式返回到客户端。如果没 有匹配的 result，响应客户端为信息为:没有请求的资源。

**总结**
主要是对xml的解析，做完后感觉进步很大，鸣谢我聪：https://github.com/kingcong
