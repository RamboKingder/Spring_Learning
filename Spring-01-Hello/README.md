### 背景：
这是我学习黑马SSM教程P1-P20时写的代码和笔记，他的视频不自己记一记的话直接就忘了。。。

我用到的Spring-01-Hello项目的Github地址：[https://github.com/RamboKingder/Spring_Learning/tree/main](https://github.com/RamboKingder/Spring_Learning/tree/main)

## 一、创建一个简单的Spring项目的具体流程：
##### 1. 使用Maven-archetype-webapp模板创建一个简单的Spring项目
用模板创建的项目需要两个优化：在main文件夹下添加**java**文件夹和**resources**文件夹、更换**web.xml**文件
##### 2.简单的Spring项目只需要在pom.xml导入spring-context即可
(创建项目后pom.xml中会自动添加junit的坐标，junit是用来进行单元测试的，即使不是main方法也能执行的意思
但是要注意它的scope标注的是test作用域，也就是说测试的代码要写在test文件夹下才能进行单元测试的功能)

##### 3.在resources文件夹下创建Spring的配置文件applicationContext.xml
（如果还要引入其它配置文件\<import resource="applicationContext-xxx.xml"/>，classpath会自动识别resources文件夹，所以不用加路径）

##### 4.在java文件夹下编写dao、service和web包以及其对应的接口和类的实现
- 我在UserDaoImpl类中注入了两个基本属性：Strnig username和int age
- 除此之外还注入了三个非自定义类的引用属性
- 通过set方法注入的要用<property标签、通过有参构造注入的要用<constructor标签
  **然后我又在UserServiceImpl类中注入了一个UserDao类的对象**

## 二、Spring的控制反转(IOC)思想
通过上面我们可以发现，在Spring中对象的创建基本都不是自己new出来的
而是都把他们放到Spring容器当中去，并且可以将一个对象注入到另一个对象当中去
然后对象的创建就都可以交给Spring容器去完成，而我们需要用的时候去getBean()就好了:
```java
// 先通过classpath去加载resources文件夹下的Spring配置文件：applicationContext.xml
ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
// 然后从容器中通过getBean方法去去对象出来，只需要指定对象的id就可以了
// 如果对象的作用域配置的是prototype的话，还可以通过指定类去直接获取
(UserDao) userDao = (UserDao) app.getBean(UserDao.class);
```