package demo003functionalinterface;

import java.util.function.Predicate;
import org.junit.Test;

public class Demo08Predicate_And_Or_Negate {

    /**
     * 使用Lambda表达式判断一个字符串即包含W，也包含H
     */
    @Test
    public void test01() {
        testPredicate01((str1) -> {
            return str1.contains("W");
        }, (str2) -> {
            return str2.contains("H");
        });

        testPredicate02((str1) -> {
            return str1.contains("W");
        }, (str2) -> {
            return str2.contains("H");
        });
    }

    /**
     * 使用Lambda表达式判断一个字符串即包含W或者包含H
     */
    @Test
    public void test02() {
        testPredicate03((str1) -> {
            return str1.contains("W");
        }, (str2) -> {
            return str2.contains("H");
        });
    }

    /**
     * 使用Lambda表达式判断一个字符串中不包含W
     */
    @Test
    public void test03() {
        testPredicate04((str1) -> {
            return str1.contains("W");
        });
    }

    public static void testPredicate01(Predicate<String> p1, Predicate<String> p2) {
        String str = "Hello World";
        boolean b1 = p1.test(str);
        boolean b2 = p2.test(str);
        if (b1 && b2) {
            System.out.println("即包含W，也包含H");
        }
    }

    /**
     * testPredicate01的简写方式
     *
     * @param p1
     * @param p2
     */
    public static void testPredicate02(Predicate<String> p1, Predicate<String> p2) {
        String str = "Hello World";
        boolean b = p1.and(p2).test(str);
        if (b) {
            System.out.println("即包含W，也包含H");
        }
    }

    public static void testPredicate03(Predicate<String> p1, Predicate<String> p2) {
        String str = "Hello orld";
        boolean b = p1.or(p2).test(str);
        if (b) {
            System.out.println("即包含W或者包含H");
        }
    }

    public static void testPredicate04(Predicate<String> p1) {
        String str = "Hello orld";
        boolean b = p1.negate().test(str);
        if (b) {
            System.out.println("字符串中不包含W");
        }
    }
}
