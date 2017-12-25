package n3.snail.java.java8.lamda;

/**
 * lambda表达式的使用
 *
 * @author N3 on 2017/12/15.
 */
public class LambdaExpression {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda")).start();
        SimpleInterface function = () -> {int i=4; return i%2==0;};
        System.out.println(function.execute());
    }

    private static interface SimpleInterface {
        boolean execute();
    }
}
