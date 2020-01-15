package demo001Lambda;

import org.junit.Test;

/*
    Lambda的标准格式：
        Lambda表达式是一个匿名函数，而函数相当于Java中的方法
        (参数列表...) -> {
            代码体;
        }
        (参数列表...)：参数列表
        ->：没有实际含义，起到连接的作用
        {}：方法体

        public static void main(String[] args) {
        }
*/
public class Demo02LambdaUse {

    /**
     * 无参数无返回值的Lambda
     */
    @Test
    public void test01() {
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类的");
            }
        });

        // 方法的参数是接口就可以考虑使用Lambda表达式，可以认为Lambda表达式就是对接口中的抽象方法的重写
        goSwimming(() -> {
            System.out.println("我是Lambda表达式的");
        });
    }

    public static void goSwimming(Swimmable s) {
        s.swimming();
    }

    /**
     * 有参有返回值的Lambda
     */
    @Test
    public void test02 () {
        goSmoking(new Smokeable() {
            @Override
            public int smoking(String name) {
                System.out.println("匿名内部类抽了" + name + "的烟");
                return 5;
            }
        });

        goSmoking((String name) -> {
            System.out.println("Lambda表达式抽了" + name + "的烟");
            return 10;
        });
    }
    
    public static void goSmoking(Smokeable s) {
        int i = s.smoking("中华");
        System.out.println("返回值：" + i);
    }
}
