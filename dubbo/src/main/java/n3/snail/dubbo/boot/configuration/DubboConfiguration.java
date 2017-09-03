package n3.snail.dubbo.boot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@Configuration
@ImportResource({"classpath:dubbo.xml"})
public class DubboConfiguration {

}
