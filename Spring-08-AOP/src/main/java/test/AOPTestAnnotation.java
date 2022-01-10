package test;

import com.lxl.aopAnnotation.TargetInterface;
import com.lxl.aopAnnotation.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
// @ContextConfiguration("classpath:applicationContext-anno.xml")
public class AOPTestAnnotation {

    @Autowired
    private TargetInterface target;

    @Test
    public void test(){
        // 不再像之前动态代理的代码一样去调用proxy，直接调target，Spring会帮我们自动实现代理
        target.service();
    }
}
