package demo005stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo07Parallel {

    @Test
    public void test01() {
        Stream.of(4, 5, 3, 9, 1, 2, 6).filter(s -> {
            System.out.println(Thread.currentThread());
            return s > 3;
        }).count();
    }

    /**
     * <pre>
     *  获取并行Stream流：
     *      1、直接获取并行的Stream流
     * </pre>
     */
    @Test
    public void testGetParallelStream01() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.parallelStream();
    }

    /**
     * <pre>
     *  获取并行Stream流：
     *      2、将串行流转成并行流
     * </pre>
     */
    @Test
    public void testGetParallelStream02() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream().parallel();
    }

    @Test
    public void testParallel() {
        Stream.of(4, 5, 3, 9, 1, 2, 6).parallel().filter(s -> {
            System.out.println(Thread.currentThread());
            return s > 3;
        }).count();
    }

    private static final int times = 500000000;
    long start;

    @Before
    public void before() {
        start = System.currentTimeMillis();
    }

    /**
     * 测试效率，正常for循环
     */
    @Test
    public void testFor() {
        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        // cost 145 ms.
    }

    /**
     * 测试效率，串行的Stream
     */
    @Test
    public void testStream() {
        LongStream.rangeClosed(0, times).reduce(0, Long::sum);
        // cost 254 ms.
    }

    /**
     * 测试效率，并行的Stream
     */
    @Test
    public void testParallelStream() {
        LongStream.rangeClosed(0, times).parallel().reduce(0, Long::sum);
        // cost 175 ms.
    }

    @After
    public void after() {
        long end = System.currentTimeMillis();
        System.out.println("cost " + (end - start) + " ms.");
    }

    /**
     * parallelStream线程安全问题
     */
    @Test
    public void testParallelStreamNotice01() {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 1000).parallel().forEach(list::add);
        System.out.println("list.size() = " + list.size());
    }

    /**
     * <pre>
     *  解决parallelStream线程安全问题：
     *      1、使用同步代码块
     * </pre>
     */
    @Test
    public void testParallelStreamNotice02() {
        List<Integer> list = new ArrayList<>();
        Object obj = new Object();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (obj) {
                list.add(i);
            }
        });
        System.out.println("list.size() = " + list.size());
    }

    /**
     * <pre>
     *  解决parallelStream线程安全问题：
     *      2、使用线程安全的集合
     * </pre>
     */
    @Test
    public void testParallelStreamNotice03() {
        Vector<Integer> vector = new Vector<>();
        IntStream.rangeClosed(1, 1000).parallel().forEach(vector::add);
        System.out.println("vector.size() = " + vector.size());
    }

    /**
     * <pre>
     *  解决parallelStream线程安全问题：
     *      2、使用线程安全的集合
     * </pre>
     */
    @Test
    public void testParallelStreamNotice04() {
        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        IntStream.rangeClosed(1, 1000).parallel().forEach(synchronizedList::add);
        System.out.println("synchronizedList.size() = " + synchronizedList.size());
    }
    
    /**
     * <pre>
     *  解决parallelStream线程安全问题：
     *      3、调用Stream流的collect/toArray
     * </pre>
     */
    @Test
    public void testParallelStreamNotice05() {
        List<Integer> collectList = IntStream.rangeClosed(1, 1000).parallel().boxed().collect(Collectors.toList());
        System.out.println("collectList.size() = " + collectList.size());
    }
}
