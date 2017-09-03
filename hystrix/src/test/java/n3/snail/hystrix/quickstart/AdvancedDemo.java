package n3.snail.hystrix.quickstart;

import com.netflix.hystrix.strategy.HystrixPlugins;
import n3.snail.hystrix.quickstart.command.AdvancedCommand;
import n3.snail.hystrix.quickstart.plugin.HystrixPluginsImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**Hyxtrix高级使用样例
 * @author n3 on 2016/11/27.
 */
public class AdvancedDemo {

    /**
     * 代码示例：HystrixPlugins拓展，在Command实例化之前执行，通常是HystrixContextFilter
     */
    @BeforeTest
    public void before() {
        HystrixPlugins.getInstance().registerCommandExecutionHook(new HystrixPluginsImpl.ExecutionHookExample());
    }

    @Test
    public void testCommandName() {
        AdvancedCommand command = new AdvancedCommand();
        String result = command.execute();
        System.out.println("command name=" + command.getCommandKey().name());
        System.out.println("command result=" + result);
    }
}
