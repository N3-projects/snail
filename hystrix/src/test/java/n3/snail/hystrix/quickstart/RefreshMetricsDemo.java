package n3.snail.hystrix.quickstart;

import com.netflix.hystrix.HystrixCounters;
import n3.snail.hystrix.quickstart.command.FallbackCommand;
import n3.snail.hystrix.quickstart.plugin.HystrixPluginsImpl;
import org.testng.annotations.Test;

/**Hystrix刷新度量指标样例
 * @author n3 on 2016/12/26.
 */
public class RefreshMetricsDemo {

    @Test
    public void testRefreshMetrics() {
        HystrixPluginsImpl.registExamplePlugins();
        FallbackCommand command = new FallbackCommand(4);
        int result = command.execute();
        System.out.println("command result=" + result);
        HystrixPluginsImpl.PropertiesStrategyExample.forceOpen();
        command = new FallbackCommand(7);
        result = command.execute();
        System.out.println("command result=" + result);
    }

    @Test
    public void testReset() {
        HystrixPluginsImpl.registExamplePlugins();
        FallbackCommand command = new FallbackCommand(5);
        System.out.println(HystrixCounters.getGlobalConcurrentThreadsExecuting());
        HystrixPluginsImpl.PropertiesStrategyExample.forceOpen();
        int result = command.execute();
        System.out.println("command result=" + result);
        command.getExecutionException().printStackTrace();
    }
}
