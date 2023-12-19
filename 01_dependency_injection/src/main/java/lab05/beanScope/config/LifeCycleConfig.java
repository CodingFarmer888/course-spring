package lab05.beanScope.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lab05.beanScope.bean.LifeCycleBean;

@Configuration
@ComponentScan(basePackageClasses = {LifeCycleBean.class})
public class LifeCycleConfig {

}
