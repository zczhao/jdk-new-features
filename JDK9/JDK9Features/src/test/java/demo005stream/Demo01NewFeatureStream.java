package demo005stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class Demo01NewFeatureStream {

    /**
     * takeWhile：从头开始筛选，从stream中依次获取满足条件的元素，直到不满足条件为止结束获取，只要遇到第一个不满足的条件元素马上停止获取
     */
    @Test
    public void testTakeWhile() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> listResult = list1.stream().takeWhile(x -> x < 3).collect(Collectors.toList());
        System.out.println(listResult); // 结果：[1, 2]
    }

    /**
     * dropWhile：从头开始删除，从Stream中依次删除满足条件的元素，直到不满足条件为止结束删除
     */
    @Test
    public void testDropWhile() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> listResult = list1.stream().dropWhile(x -> x < 3).collect(Collectors.toList());
        System.out.println(listResult); // 结果：[3, 4, 5]
    }

    /**
     * ofNullable：JDK8中Stream不能完全为nul(一个元素不能为null，多个元素可以存在null),否则会报空指针异常。而JDK9中ofNullable方法允许创建一个单元素Stream，可以包含一个非空元素，也可以创建一个空Stream
     */
    @Test
    public void testOfNullable() {
        Stream<Integer> stream = Stream.of(1, 2, null);
        stream.forEach(System.out::println);
        System.out.println();

        // 空指针异常
        // stream = Stream.of(null);
        stream = Stream.ofNullable(null);
        stream.forEach(System.out::println);
    }

    /**
     * iterate：可以重载迭代器
     */
    @Test
    public void testIterate() {
        IntStream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::println);
    }

}
