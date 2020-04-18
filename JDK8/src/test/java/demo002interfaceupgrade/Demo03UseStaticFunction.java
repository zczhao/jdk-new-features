package demo002interfaceupgrade;

import org.junit.Test;

/**
 * 接口静态方法
 *
 */
public class Demo03UseStaticFunction {

    @Test
    public void test01() {
       // 接口静态方法的使用：直接使用接口名调用即可：接口名.静态方法名();
       AAA.test01();
    }

}

interface AAA {
    /*
    接口静态方法的定义格式：
        修饰符 static 返回值类型 方法名() {
            代码;
        } 
    */
    public static void test01() {
        System.out.println("我是接口静态方法");
    }
}

class BBB implements AAA {
}
/*
接口默认方法和静态方法的区别：
    1、默认方法通过实例调用，静态方法通过接口名调用
    2、默认方法可以被继承，实现类可以直接使用接口默认方法，也可以重写接口默认方法
    3、静态方法不能被继承，实现类不能重写接口静态方法，只能使用接口名调用
*/