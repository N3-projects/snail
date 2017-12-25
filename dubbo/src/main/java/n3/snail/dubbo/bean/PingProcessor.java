package n3.snail.dubbo.bean;

import org.springframework.stereotype.Component;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
@Component
public class PingProcessor {

    public String action() {
        return "pong";
    }
}
