package n3.snail.hystrix.quickstart;

import n3.snail.hystrix.quickstart.command.FallbackCommand;
import org.testng.annotations.Test;

import java.util.concurrent.locks.LockSupport;

/**Hystrix降级使用样例
 * @author n3 on 2016/11/27.
 */
public class FallbackDemo {

    @Test
    public void testFallback() {
        FallbackCommand command = new FallbackCommand(1);
        System.out.println(command.execute());
        System.out.println("-----------------------");

        command = new FallbackCommand(3);
        System.out.println(command.execute());
        System.out.println("-----------------------");

        command = new FallbackCommand(5);
        System.out.println(command.execute());
        System.out.println("-----------------------");

        LockSupport.park();
    }

}
