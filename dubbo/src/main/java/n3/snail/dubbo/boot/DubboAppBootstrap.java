package n3.snail.dubbo.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@SpringBootApplication(scanBasePackages = "n3.snail.dubbo.boot")
public class DubboAppBootstrap {

    public static void main(String[] args) {
        start(args);
        park();
    }

    public static void start(String[] args) {
        SpringApplication app = new SpringApplication(DubboAppBootstrap.class);
        // 纯dubbo服务应用，不需要提供web服务
        app.setWebApplicationType(WebApplicationType.NONE);
        app.setBannerMode(Banner.Mode.OFF);

        app.run(args);
    }

    private static void park() {
        // todo 如何解决优雅停机
        LockSupport.park();
    }

}
