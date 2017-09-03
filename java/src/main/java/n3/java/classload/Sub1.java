package n3.java.classload;

/**
 * @author N3 on 2017/3/30.
 */
public class Sub1 extends Super {
    static {
        System.out.println("Sub1 static block");
    }

    public final static ClassLoadingSemaphore semaphore = new ClassLoadingSemaphore();
}
