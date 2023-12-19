package lab04.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 1. 宣告是配置類
@Configuration
/**
 * 2. 告訴Spring去要去抓元件，並叫Spring建立實體。
 * 掃描哪些package @ComponentScan -> 需要指定pagage路徑 basePackages
 * 這裡採用正向表列，告訴Spring有哪些地方要掃描
 */
@ComponentScan(basePackages = "lab04.annotation.bean")
public class AnnotationConfig {

}
