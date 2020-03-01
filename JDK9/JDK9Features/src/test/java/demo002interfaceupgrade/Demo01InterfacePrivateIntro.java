package demo002interfaceupgrade;

import org.junit.Test;

/**
 * 问题：接口里写多个默认方法或者静态方法的时候，可能会遇到程序重复的问题
 */
public class Demo01InterfacePrivateIntro {

    @Test
    public void test01() {
        ChinaPeople chinaPeople = new ChinaPeople();
        chinaPeople.sleep();
        chinaPeople.eat();
        chinaPeople.doXxx();
    }

}

class Monkey implements Animal {

    @Override
    public void sleep() {
        System.out.println("躺着睡");
    }
}

/**
 * 存在的问题：eat、doXxx方法存在着代码冗余问题
 */
interface Animal {

    void sleep();

    default void eat() {
        System.out.println("eat...");
        System.out.println("喝水");
    }

    default void doXxx() {
        System.out.println("doXxx...");
        System.out.println("喝水");
    }
}
