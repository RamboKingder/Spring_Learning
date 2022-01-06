学习黑马SSM教学视频P37-P41时写的代码

### 1.Spring集成web
ServletContextListener会监听servletContext对象的创建
我们写一个ContextLoaderListener实现ServletContextListener接口
让它在监听到servletContext创建--也就是服务器启动的时候
让它去创建ApplicationContext对象并保存在servletContext对象中
然后编写一个静态方法，传入servletContext对象即可得到ApplicationContext对象


### 使用官方的接口
其实上述功能Spring框架已经替我们封装好了
先导入spring-web坐标
再去web.xml中去配置这个Spring官方写好的监听器

```xml
<context-param>
    <param-name>contextClass</param-name>
    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
  </context-param>

  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>com.lxl.config.SpringConfiguration</param-value>
  </context-param>

  <!--配置监听器-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
```