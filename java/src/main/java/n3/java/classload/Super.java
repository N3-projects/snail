package n3.java.classload;

/**
 * @author N3 on 2017/3/30.
 */
public class Super {

    public static final String HELLO_WORLD = "hello world";
    public static int staticNotFinalInt = 7;

    static {
        System.out.println("Super static block ");
    }
}
