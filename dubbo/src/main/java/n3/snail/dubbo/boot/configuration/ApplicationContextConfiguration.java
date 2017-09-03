package n3.snail.dubbo.boot.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@Configuration
@ComponentScan(basePackages = "n3.snail.dubbo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationContextConfiguration {

}
