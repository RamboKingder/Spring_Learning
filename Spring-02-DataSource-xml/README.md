### 背景
这是我学习黑马SSM教程P21-P27时记下的笔记，项目的地址在：[https://github.com/RamboKingder/Spring_Learning](https://github.com/RamboKingder/Spring_Learning)

##### 这一节其实没啥太新的东西，就是数据源对象需要用set方法去设置：driver、url、username、password参数
但是配置的方式分为很多种：
##### 一、平时最常用的方法就是在代码里面new DataSource对象，然后把字符串传给datasource的setXXX()方法，例如：
```java
DruidDataSource dataSource = new DruidDataSource();
dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
dataSource.setUsername("LongXiaolan");
dataSource.setPassword("rootpassword");
Connection conn = dataSource.getConnection();
System.out.println(conn);
conn.close();
```
上面看到，dataSource需要的参数直接用字符串给出的，后续维护代码需要来找这部分，很麻烦
而且在实际开发中，通常喜欢把数据库相关的参数放到一个properties文件中，把它单独配置，于是有了下面的方法：

##### 二、通过properties文件保存和加载数据源需要的dirver, url, username, password等参数：
```java
// 路径在resources下，且不需要文件的扩展名
 ResourceBundle rb = ResourceBundle.getBundle("jdbc");
 String driver = rb.getString("jdbc.driver");
 String url = rb.getString("jdbc.url");
 String username = rb.getString("jdbc.username");
 String password = rb.getString("jdbc.password");

 ComboPooledDataSource dataSource = new ComboPooledDataSource();
 dataSource.setDriverClass(driver);
 dataSource.setJdbcUrl(url);
 dataSource.setUser(username);
 dataSource.setPassword(password);
 Connection conn = dataSource.getConnection();
 System.out.println(conn);
 conn.close();
  ```
这样的话，后续我们只需要去修改properties文件就行了，而不用去找对应的代码了
但是这样还是存在一个问题：我们违反了Spring的控制反转思想
这个数据源对象是我们在代码中new出来的，这个应该交给Spring容器去做才行

##### 三、直接在xml中创建一个数据源的Bean，并在其中直接去配置它的参数
```java
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
 <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
 <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test_db"/>
 <property name="user" value="LongXiaolan"/>
 <property name="password" value="rootpassword"/>
 </bean>
 ```

这种方法确实做到了控制反转，但是它又没有达到我们用properties文件单独配置数据库的要求

# 四、因此需要结合二和三，让xml加载jdbc.properties文件并获得连接信息(重点！)
首先，在applicationContext.xml配置文件中引入context命名空间：
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context  
http://www.springframework.org/schema/context/spring-context.xsd">

<!--加载外部的properties文件-->
<context:property-placeholder location="classpath:jdbc.properties"/>

<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
```
**注意：在DataSource的配置中，它是通过${}表达式的方式去使用jdbc.properties文件中的key的
这就是在Spring的配置文件中加载properties文件的具体方法**
