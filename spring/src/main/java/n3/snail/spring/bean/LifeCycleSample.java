package n3.snail.spring.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * spring bean的生命周期管理<br>
 * 首先调用javax annotation注解方法，然后调用beans factory接口方法，最后调用bean声明时指定的方法
 * @author hzyemao
 * @version 1.0 , 2017/12/26
 */
public class LifeCycleSample implements InitializingBean, DisposableBean {

    private static final Logger logger = LogManager.getLogger(LifeCycleSample.class);

    /* 初始化方法 */

    @PostConstruct
    public void postConstruct() {
        // 1
        logger.info("annotation @PostConstruct method invoke");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 2
        logger.info("interface InitializingBean afterPropertiesSet method invoke");
    }

    public void initMethod() {
        // 3
        logger.info("bean init-method method invoke");
    }

    /* 销毁方法 */

    @PreDestroy
    public void preDestroy() {
        // 1
        logger.info("annotation @PreDestroy method invoke");
    }

    @Override
    public void destroy() throws Exception {
        // 2
        logger.info("interface DisposableBean destroy method invoke");
    }

    public void destroyMethod() {
        // 3
        logger.info("bean destroy-method method invoke");
    }
}
