package n3.snail.dubbo.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@SpringBootApplication(scanBasePackages = "n3.snail.dubbo.boot")
public class ApplicationBootstrap {

    public static void main(String[] args) {
        start(args);
        park();
    }

    public static void start(String[] args) {
        SpringApplication app = new SpringApplication(ApplicationBootstrap.class);
        app.setWebEnvironment(false);
        app.setBannerMode(Banner.Mode.OFF);

        // 这里可以使用api指定xml配置文件，但一般用注解形式注入
//        Set<Object> set = new HashSet<Object>();
//        set.add("classpath:applicationContext.xml");
//        app.setSources(set);
        app.run(args);
    }

    private static void park() {
        LockSupport.park();
    }

}
