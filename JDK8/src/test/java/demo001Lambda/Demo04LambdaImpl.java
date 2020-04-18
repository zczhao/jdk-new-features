package demo001Lambda;

import org.junit.Test;

public class Demo04LambdaImpl {

    @Test
    public void test01() {
        //  匿名内部类在编译后会形成一个新的类
        /*
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("使用匿名内部类实现游泳");
            }
        });
        */
        
        /*
            Lambda表达式不能用工具反编译：
                使用命令： javap -c -p 文件名.class
                            -c: 表示对代码进行反编译
                            -p: 显示所有类和成员
        */
        goSwimming(() -> {
            System.out.println("Lambda表达式实现游泳");
        });
    }

    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
