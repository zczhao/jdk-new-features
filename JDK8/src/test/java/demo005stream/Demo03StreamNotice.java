package demo005stream;

import java.util.stream.Stream;
import org.junit.Test;

public class Demo03StreamNotice {

    /**
     * <pre>
     *  注意事项：
     *      1、Stream只能操作一次
     * </pre>
     */
    @Test
    public void test01() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        long count1 = stream.count();
        System.out.println("count1 = " + count1);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // long count2 = stream.count();
        // System.out.println("count2 = " + count2);
    }

    /**
     * <pre>
     *  注意事项：
     *      2、Stream方法返回的是新的流
     * </pre>
     */
    @Test
    public void test02() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        Stream<String> limit = stream.limit(1);
        System.out.println(stream);
        System.out.println(limit);
    }

    /**
     * <pre>
     *  注意事项：
     *      3、Stream不调用终结方法，中间的操作不会执行
     * </pre>
     */
    @Test
    public void test03() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        stream.filter((s) -> {
            System.out.println("s = " + s);
            return true;
        });
    }

}
