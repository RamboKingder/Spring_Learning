package test;

import com.lxl.aop.MyAspect;
import com.lxl.aop.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void test(){
        // 不再像之前动态代理的代码一样去调用proxy，直接调target，Spring会帮我们自动实现代理
        target.service();
    }
}
