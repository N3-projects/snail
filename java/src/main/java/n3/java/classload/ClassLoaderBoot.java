package n3.java.classload;

/**
 * @author N3 on 2017/3/30.
 */
public class ClassLoaderBoot {

    public static void main(String[] args) throws Exception {
        //访问常量池变量不会进行类加载
        System.out.println(Super.HELLO_WORLD);

        //通过子类访问父类静态对象，不会加载子类，只加载父类
        System.out.println(Sub1.staticNotFinalInt);

//        Class.forName("n3.java.classload.Sub1");

        ClassUtil.loadSubClassesInResourcePath(Super.class, "");
    }
}
