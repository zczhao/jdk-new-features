package demo001Lambda;

import org.junit.Test;

/*
Lambda的前提条件：
    1、方法的参数或局部变量类型必须为接口才能使用Lambda
    2、接口中有且仅有一个抽象方法
*/
public class Demo06LambdaCondition {

    @Test
    public void test01() {
        // 方法的参数或局部变量类型必须为接口才能使用Lambda
        test(() -> {
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };

        Flyable flyable = () -> {
            System.out.println("flyable");
        };
    }

    public static void test(Flyable flyable) {

    }

}

// 只有一个抽象方法的接口称为函数式接口，就能使用Lambda表达式
@FunctionalInterface // 检测这个接口是不是只有一个抽象方法
interface Flyable {
    public abstract void eat();
}
/*
Lambda和匿名内部类对比：
    1、所需的类型不一样
        匿名内部类，需要的类型可以是类，抽象类、接口
        Lambda表达式，需要的类型必须是接口
    2、抽象方法的数量不一样
        匿名内部类所需的接口中抽象方法的数量随意
        Lambda表达式所需的接口只能有一个抽象方法
    3、实现原理不同
        匿名内部类是在编译后会形成class文件
        Lambda表达式是在程序运行的时候动态生成class
*/
