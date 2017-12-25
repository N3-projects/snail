package n3.snail.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author N3 on 2017/10/1.
 */
@Activate(group = Constants.PROVIDER)
public class N3DubboFilter implements Filter {

    private static final Logger log = LogManager.getLogger(N3DubboFilter.class);

    public N3DubboFilter() {
        log.info(" =,=,=,=,=,=,=,=,=,=,=,=,=,= ");
        log.info("自定义过滤器N3DubboFilter启用");
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        log.info(" =,=,=,=,=,=,=,=,=,=,=,=,=,= ");
        return invoker.invoke(invocation);
    }
}
