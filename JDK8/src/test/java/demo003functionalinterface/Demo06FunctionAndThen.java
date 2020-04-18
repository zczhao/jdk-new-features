package demo003functionalinterface;

import java.util.function.Function;
import org.junit.Test;

public class Demo06FunctionAndThen {

    /**
     * 使用Lambda表达式将字符串转成数字,第二个操作将这个数字乘以5
     */
    @Test
    public void test01() {
        getNumber((str) -> {
            return Integer.parseInt(str);
        }, (num) -> {
            return num * 5;
        });
    }

    @Test
    public void test02() {
        getNumberAndThen((str) -> {
            return Integer.parseInt(str);
        }, (num) -> {
            return num * 5;
        });
    }

    public static void getNumber(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        Integer num1 = f1.apply("6");
        System.out.println("num1 = " + num1);
        Integer num2 = f2.apply(num1);
        System.out.println("num2 = " + num2);
    }

    public static void getNumberAndThen(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        Integer num = f1.andThen(f2).apply("6");
        System.out.println("num = " + num);
    }
}
