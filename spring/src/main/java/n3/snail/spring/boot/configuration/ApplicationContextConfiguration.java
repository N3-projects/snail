package n3.snail.spring.boot.configuration;

import n3.snail.spring.bean.LifeCycleSample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 系统环境配置，一般用来加载系统需要声明的配置和bean<br>
 * 类似原来的总的applicationContext.xml配置
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@Configuration
@ComponentScan(basePackages = "n3.snail.spring")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationContextConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifeCycleSample lifeCycleSample() {
        return new LifeCycleSample();
    }
}
