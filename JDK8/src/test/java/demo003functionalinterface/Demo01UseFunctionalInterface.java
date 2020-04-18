package demo003functionalinterface;

import org.junit.Test;

public class Demo01UseFunctionalInterface {

    @Test
    public void test01() {
        // Lambda使用时不关心接口名，抽象方法名，只关心抽象方法的参数列表和返回值类型
        test((a, b) -> System.out.println(a + b));
    }

    public static void test(Operation op) {
        op.getSum(1, 2);
    }

}

interface Operation {

    public abstract void getSum(int a, int b);
}

/*
常用内置函数式接口：
    它们主要在java.util.function包中，最常用的几个接口：
    1、Supplier接口
        @FunctionalInterface
        public interface Supplier<T> {
            T get();
        }
    2、Consumer接口
        @FunctionalInterface
        public interface Consumer<T> {
            void accept(T t);
        }
    3、Function接口
        @FunctionalInterface
        public interface Function<T, R> {
            R apply(T t);
        }
    4、Predicate接口
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
        }
 */
