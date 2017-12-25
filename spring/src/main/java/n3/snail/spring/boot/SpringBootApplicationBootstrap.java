package n3.snail.spring.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 启动类<br>
 * 应用启动时会自动加载src/main/resource目录下的application.properties配置文件，用于指定系统级的基本配置<br>
 * 通过@SpringBootApplication注解指定的scanBasePackages加载指定目录下的SpringConfiguration配置
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@SpringBootApplication(scanBasePackages = "n3.snail.spring.boot")
public class SpringBootApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootApplicationBootstrap.class);
//        app.setWebEnvironment(false);     //默认为true，如果不需要加载web容器可设置为false
        app.setBannerMode(Banner.Mode.OFF); //启动日志不显示广告位

        // 这里可以使用api指定xml配置文件，但一般用注解形式注入
//        Set<Object> set = new HashSet<Object>();
//        set.add("classpath:applicationContext.xml");
//        app.setSources(set);
        app.run(args);
    }

}
