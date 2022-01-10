package com.lxl.aopAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lxl.aopAnnotation")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
