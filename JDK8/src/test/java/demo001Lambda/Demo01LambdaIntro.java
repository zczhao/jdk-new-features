package demo001Lambda;

public class Demo01LambdaIntro {

    public static void main(String[] args) {
        /*
            使用内部类存在的问题
                1、定义了一个没有名字的类
                2、这个类实现了Runnable接口
                3、创建了这个类的对象

            使用匿名内部类的语法是很冗余的，
            最关注的是run方法和里面要执行的代码
         */
        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程执行的代码");
            }
        }).start();

        /*
                Lambda表达式体现的函数式编程思想，只需要将需要执行的代码放到函数中(函数就是类中的方式)，
            Lambda就是一个匿名函数，只需要将执行的代码放到Lambda表达式中即可。

            Lambda表达式的好处：可以简化匿名内部类，让代码更加精简
        */
        new Thread(() -> {
            System.out.println("Lambda表达式执行的代码");
        }).start();

    }

}
