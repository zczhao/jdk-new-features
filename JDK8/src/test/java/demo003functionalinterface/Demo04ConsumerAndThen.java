package demo003functionalinterface;

import java.util.function.Consumer;
import org.junit.Test;

public class Demo04ConsumerAndThen {

    /**
     * 使用Lambda表达式先将一个字符串转成小写的字符串，再转成大写
     */
    @Test
    public void test01() {
        printHello((str1) -> {
            System.out.println(str1.toLowerCase());
        }, (str2) -> {
            System.out.println(str2.toUpperCase());
        });
    }
    
     @Test
    public void test02() {
        printHelloAndThen((str1) -> {
            System.out.println(str1.toLowerCase());
        }, (str2) -> {
            System.out.println(str2.toUpperCase());
        });
    }

    public static void printHello(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello World";
        c1.accept(str);
        c2.accept(str);
    }

    public static void printHelloAndThen(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello World";
        c1.andThen(c2).accept(str);
    }
}
