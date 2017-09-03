package n3.snail.hystrix.quickstart.module;

/**
 * @author n3 on 2016/12/26.
 */
public class PropertiesConstant {

    public static volatile boolean isForceOpen = false;

    public static void forceOpen() {
        isForceOpen = true;
    }
}
