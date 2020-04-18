package demo004methodref;

import java.util.Arrays;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;

public class Demo02 {

    /**
     * 对象::实例方法
     */
    @Test
    public void test01() {
        Date now = new Date();
        Supplier<Long> s1 = () -> {
            return now.getTime();
        };
        System.out.println("s1 = " + s1.get());

        Supplier<Long> s2 = now::getTime;
        System.out.println("s2 = " + s2.get());
        /*
            注意：方法引用有两个注意事项
                1、被引用的方法，参数要和接口中抽象方法的参数一样
                2、当接口抽象方法有返回值时，被引用的方法也必须有返回值
         */
    }

    /**
     * 类名::引用静态方法
     */
    @Test
    public void test02() {
        Supplier<Long> s1 = () -> {
            return System.currentTimeMillis();
        };
        System.out.println("s1 = " + s1.get());

        Supplier<Long> s2 = System::currentTimeMillis;
        System.out.println("s2 = " + s2.get());
    }

    /**
     * 类名::引用实例方法
     */
    @Test
    public void test03() {
        Function<String, Integer> f1 = (s) -> {
            return s.length();
        };
        System.out.println("f1 = " + f1.apply("abc"));

        Function<String, Integer> f2 = String::length;
        System.out.println("f2 = " + f2.apply("abc"));

        BiFunction<String, Integer, String> bif1 = (str, index) -> {
            return str.substring(index);
        };
        String str1 = bif1.apply("hello", 2);
        System.out.println("str1 = " + str1);

        BiFunction<String, Integer, String> bif2 = String::substring;
        String str2 = bif2.apply("hello", 2);
        System.out.println("str2 = " + str2);
    }

    /**
     * 类名::new引用构造器
     */
    @Test
    public void test04() {
        Supplier<Person> s1 = () -> {
            return new Person();
        };
        System.out.println(s1.get());

        Supplier<Person> s2 = Person::new;
        System.out.println(s2.get());

        BiFunction<String, Integer, Person> bif1 = (name, age) -> {
            return new Person(name, age);
        };
        Person person1 = bif1.apply("tom", 18);
        System.out.println("person1 = " + person1);

        BiFunction<String, Integer, Person> bif2 = Person::new;
        Person person2 = bif2.apply("jerry", 18);
        System.out.println("person2 = " + person2);
    }

    /**
     * 数组::new 引用数组构造器
     */
    @Test
    public void test05() {
        Function<Integer, int[]> f1 = (len) -> {
            return new int[len];
        };
        int[] arr1 = f1.apply(10);
        System.out.println("arr1 = " + Arrays.toString(arr1));

        Function<Integer, int[]> f2 = int[]::new;
        int[] arr2 = f2.apply(20);
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }
    
}
