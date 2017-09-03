package n3.snail.hystrix.quickstart.plugin;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesCommandDefault;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import n3.snail.hystrix.quickstart.module.PropertiesConstant;

import java.util.concurrent.TimeUnit;

/**
 * @author n3 on 2016/12/19.
 */
public class HystrixPluginsImpl {

    public static class ExecutionHookExample extends HystrixCommandExecutionHook {

        @Override
        public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
            System.out.println("Execution Start");
        }

        @Override
        public <T> T onExecutionEmit(HystrixInvokable<T> commandInstance, T value) {
            System.out.println("Execution Emit, value=" + value.toString());
            return value;
        }

        @Override
        public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
            System.out.println("Execution Error, exception:");
            e.printStackTrace();
            return e;
        }

        @Override
        public <T> void onExecutionSuccess(HystrixInvokable<T> commandInstance) {
            System.out.println("Execution Success");
        }
    }

    public static class PropertiesStrategyExample extends HystrixPropertiesStrategy {

        @Override
        public HystrixCommandProperties getCommandProperties(HystrixCommandKey commandKey, HystrixCommandProperties.Setter builder) {
            builder.withCircuitBreakerForceOpen(PropertiesConstant.isForceOpen);
            return new HystrixPropertiesCommandDefault(commandKey, builder);
        }

        public static void forceOpen() {
            PropertiesConstant.forceOpen();
//            Hystrix.reset(5, TimeUnit.SECONDS);
//            registExamplePlugins();
        }
    }

    public static void registExamplePlugins() {
        HystrixPlugins.getInstance().registerCommandExecutionHook(new HystrixPluginsImpl.ExecutionHookExample());
        HystrixPlugins.getInstance().registerPropertiesStrategy(new HystrixPluginsImpl.PropertiesStrategyExample());
    }
}
