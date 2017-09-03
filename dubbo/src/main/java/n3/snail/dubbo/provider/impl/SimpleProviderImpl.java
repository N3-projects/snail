package n3.snail.dubbo.provider.impl;

import n3.snail.dubbo.provider.SimpleProvider;
import org.springframework.stereotype.Service;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
@Service("simpleProvider")
public class SimpleProviderImpl implements SimpleProvider {
    @Override
    public String ping() {
        return "pong";
    }
}
