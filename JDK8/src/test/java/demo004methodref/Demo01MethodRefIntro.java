package demo004methodref;

import java.util.function.Consumer;
import org.junit.Test;

public class Demo01MethodRefIntro {

    /**
     * 使用Lambda表达式求一个数组的和
     */
    @Test
    public void test01() {
        printSum((arr) -> {
            int sum = 0;
            for (int n : arr) {
                sum += n;
            }
            System.out.println("sum = " + sum);
        });
    }

    @Test
    public void test02() {
        printSum((arr) -> {
            getSum(arr);
        });
    }

    /**
     * 使用方法引用
     */
    @Test
    public void test03() {
        printSum(Demo01MethodRefIntro::getSum);
    }

    public static void getSum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.println("sum = " + sum);
    }

    public static void printSum(Consumer<int[]> consumer) {
        int[] arr = {11, 22, 33, 44, 55};
        consumer.accept(arr);
    }

}
/*
 常见引用方式：
    方法引用在JDK8中使用方式相当灵活，有以下几种形式：
        1、intanceName::methodName 对象::方法名
        2、ClassName::staticMethodName 类名::静态方法名
        3、ClassName::methodName 类名::普通方法
        4、ClassName::new  类名::new 调用的构造器
        5、TypeName[]::new String[]::new 调用数组的构造器
 */