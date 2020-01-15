package demo003functionalinterface;

import java.util.function.Consumer;
import org.junit.Test;

public class Demo03Consumer {

    /**
     * 使用Lambda表达式将一个字符串转成大写的字符串
     */
    @Test
    public void test01() {
        printHello((str) -> {
            System.out.println(str.toUpperCase());
        });
    }

    public static void printHello(Consumer<String> consumer) {
        consumer.accept("Hello World");
    }
}
