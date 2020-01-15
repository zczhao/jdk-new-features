package demo003functionalinterface;

import java.util.function.Function;
import org.junit.Test;

public class Demo05Function {

    /**
     * 使用Lambda表达式将字符串转成数字
     */
    @Test
    public void test01() {
        getNumber((str) -> {
            return Integer.parseInt(str);
        });
    }

    public static void getNumber(Function<String, Integer> function) {
        Integer num = function.apply("10");
        System.out.println("num = " + num);
    }

}
