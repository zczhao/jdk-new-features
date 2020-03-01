package demo002interfaceupgrade;

import org.junit.Test;

/**
 * <pre>
 * JDK9增加私有方法
 *  作用：可以把这些重复的程序提取出来，创建一个新方法，用 private 进行修饰，这样就创建了一个只有接口可以调用的私有方法。
 * 解决了接口中默认方法与静态方法代码重复的问题
 * </pre>
 */
public class Demo02InterfacePrivateIntro {

    @Test
    public void test01() {
        ChinaPeople chinaPeople = new ChinaPeople();
        chinaPeople.sleep();
        chinaPeople.eat();
        chinaPeople.doXxx();
    }

}

class ChinaPeople implements People {

    @Override
    public void sleep() {
        System.out.println("躺着睡");
    }
}

interface People {

    void sleep();

    default void eat() {
        System.out.println("eat...");
        drink();
    }

    default void doXxx() {
        System.out.println("doXxx...");
        drink();
    }

    private void drink() {
        System.out.println("喝水");
    }
}
