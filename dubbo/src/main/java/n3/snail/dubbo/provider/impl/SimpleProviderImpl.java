package n3.snail.dubbo.provider.impl;

import n3.snail.dubbo.bean.PingProcessor;
import n3.snail.dubbo.provider.SimpleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
@Service("simpleProvider")
public class SimpleProviderImpl implements SimpleProvider {

    @Autowired
    private PingProcessor pingProcessor;

    @Override
    public String ping() {
        return pingProcessor.action();
    }
}
