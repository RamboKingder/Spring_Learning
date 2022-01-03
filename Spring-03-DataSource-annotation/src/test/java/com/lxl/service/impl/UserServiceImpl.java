package com.lxl.service.impl;

import com.lxl.dao.UserDao;
import com.lxl.dao.impl.UserDaoImpl;
import com.lxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


// <bean id="userService" class="com.lxl.service.impl.UserServiceImpl">
@Service("userService") // 这个参数相当于<bean>标签的 id=""
public class UserServiceImpl implements UserService {

    // <property name="userDao" ref="userDao"/>
    @Autowired // 根据类型从Spring容器中进行匹配
    @Qualifier("userDao") // 这里相当于<bean>的ref="" 也就是写要用的对象的id
    // 上面两句其实可以合成为 @Resource(name="userDao")
    private UserDao userDao;

    // 如果使用注解开发而不是配置xml，那么系统可以通过反射进行属性赋值
    // 即set方法可以省略不写
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    @Value("Obama")
    private String driver;

    @Override
    public void save() {
        System.out.println("driver=" + driver);
        System.out.print("In UserServiceImpl object, we call its userDao.save():");
        userDao.save();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
