package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration // 标志该类是Spring的一个核心配置类

// <!--使用注解开发时，需要在配置文件中使用组件扫描-->
// <!--它会自动扫描我的base-package下的所有的注解-->
// <context:component-scan base-package="com.lxl"/>
@ComponentScan("com.lxl")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
