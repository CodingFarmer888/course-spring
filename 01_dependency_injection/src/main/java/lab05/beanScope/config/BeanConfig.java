package lab05.beanScope.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration & ComponentScan
@Configuration
@ComponentScan(basePackages = "lab05.beanScope.bean")
public class BeanConfig {

}
