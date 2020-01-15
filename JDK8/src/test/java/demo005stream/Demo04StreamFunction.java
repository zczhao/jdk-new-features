package demo005stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class Demo04StreamFunction {

    /**
     * <pre>
     *   Stream流的forEach方法
     * </pre>
     */
    @Test
    public void testForEach() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "古力娜扎", "玛尔扎哈", "萨瓦迪卡", "阿拉斯加", "真皮沙发", "拉达蹦吧", "吧啦啦", "古娜拉");
        // 得到流，调用流中的方法
        list.stream().forEach((str) -> {
            System.out.println(str);
        });

        // Lambda可以省略
        list.stream().forEach(str -> System.out.println(str));

        // Lambda可以转成方法引用
        list.stream().forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的count方法
     * </pre>
     */
    @Test
    public void testCount() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "古力娜扎", "玛尔扎哈", "萨瓦迪卡", "阿拉斯加", "真皮沙发", "拉达蹦吧", "吧啦啦", "古娜拉");

        long count = list.stream().count();
        System.out.println("count = " + count);
    }

    /**
     * <pre>
     *   Stream流的filter方法
     * </pre>
     */
    @Test
    public void testFilter() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "古力娜扎", "玛尔扎哈", "萨瓦迪卡", "阿拉斯加", "真皮沙发", "拉达蹦吧", "吧啦啦", "古娜拉");

        // 得到名字为3个字的
        // Stream<T> filter(Predicate<? super T> predicate)
        list.stream().filter(s -> {
            return s.length() == 3;
        }).forEach(System.out::println);

        // 精简写法
        list.stream().filter(s
                -> s.length() == 3
        ).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的limit方法
     * </pre>
     */
    @Test
    public void testLimit() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "古力娜扎", "玛尔扎哈", "萨瓦迪卡", "阿拉斯加", "真皮沙发", "拉达蹦吧", "吧啦啦", "古娜拉");

        // 取前3个数据
        list.stream().limit(3).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的skip方法
     * </pre>
     */
    @Test
    public void testSkip() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "古力娜扎", "玛尔扎哈", "萨瓦迪卡", "阿拉斯加", "真皮沙发", "拉达蹦吧", "吧啦啦", "古娜拉");

        // 跳过前2个数据
        list.stream().skip(2).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的map方法
     * </pre>
     */
    @Test
    public void testMap() {
        Stream<String> stream1 = Stream.of("11", "22", "33");
        // map可以将一种类型的流转换成另一种类型的流
        /*
        Stream<Integer> stream2 = stream1.map((str)-> {
            return Integer.parseInt(str);
        });
         */

        // stream1.map(str -> Integer.parseInt(str)).forEach(System.out::println);
        // 精简写法
        stream1.map(Integer::parseInt).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的sorted方法
     * </pre>
     */
    @Test
    public void testSorted() {
        // sorted()：根据元素的自然顺序排序
        Stream.of(33, 11, 22, 44).sorted().forEach(System.out::println);

        System.out.println("");

        // sorted(Comparator<? super T> comparator)：根据比较器指定的规则排序
        /*
        Stream.of(33, 11, 22, 44).sorted((o1,o2)->{
            return o2-o1;
        }).forEach(System.out::println);
         */
        Stream.of(33, 11, 22, 44).sorted((o1, o2) -> o2 - o1).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的distinct方法
     * </pre>
     */
    @Test
    public void testDistinct01() {
        Stream.of(33, 11, 22, 22, 44, 44).distinct().forEach(System.out::println);

        System.out.println("");

        Stream.of("aa", "aa", "bb", "bb", "cc", "cc").distinct().forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的distinct方法，对自定义对象去重
     * </pre>
     */
    @Test
    public void testDistinct02() {
        Stream<Person> stream = Stream.of(
                new Person("貂蝉", 18),
                new Person("杨玉环", 20),
                new Person("杨玉环", 20),
                new Person("西施", 16),
                new Person("西施", 16),
                new Person("王昭君", 25)
        );
        stream.distinct().forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的match方法
     * </pre>
     */
    @Test
    public void testMatch() {
        // allMatch：元素是否全部满足条件
        boolean b1 = Stream.of(5, 3, 6, 1).allMatch(e -> e > 0);
        System.out.println("b1 = " + b1);

        // anyMatch：元素是否任意有一个满足条件
        boolean b2 = Stream.of(5, 3, 6, 1).anyMatch(e -> e > 5);
        System.out.println("b2 = " + b2);

        // noneMatch：元素是否全部不满足条件
        boolean b3 = Stream.of(5, 3, 6, 1).noneMatch(e -> e < 0);
        System.out.println("b3 = " + b3);
    }

    /**
     * <pre>
     *   Stream流的find方法
     * </pre>
     */
    @Test
    public void testFind() {
        Optional<Integer> first = Stream.of(5, 3, 6, 1).findFirst();
        System.out.println("first = " + first.get());

        Optional<Integer> any = Stream.of(5, 3, 6, 1).findAny();
        System.out.println("any = " + any.get());
    }

    /**
     * <pre>
     *   Stream流的max和min方法
     * </pre>
     */
    @Test
    public void testMax_Min() {
        Optional<Integer> max = Stream.of(5, 3, 6, 1).max((o1, o2) -> o1 - o2);
        System.out.println("max = " + max.get());

        Optional<Integer> min = Stream.of(5, 3, 6, 1).min((o1, o2) -> o1 - o2);
        System.out.println("min = " + min.get());
    }

    /**
     * <pre>
     *   Stream流的reduce方法
     * </pre>
     */
    @Test
    public void testReduce() {
        // T reduce(T identity, BinaryOperator<T> accumulator);
        // T identity：默认值
        // BinaryOperator<T> accumulator：对数据进行处理的方式
        Integer reduce = Stream.of(4, 5, 3, 9).reduce(0, (x, y) -> {
            System.out.println("x = " + x + ", y = " + y);
            return x + y;
        });
        System.out.println("reduce = " + reduce);

        // 获取最大值
        Integer max = Stream.of(4, 5, 9, 3).reduce(0, (x, y) -> {
            return x > y ? x : y;
        });
        System.out.println("max = " + max);
    }

    /**
     * <pre>
     *   Stream流的map和reduce组合使用
     * </pre>
     */
    @Test
    public void testMapReduce() {
        // 求所有的年龄的总和
        /*
        Integer totalAge = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 59),
                new Person("黎明", 52)
        ).map(p -> p.getAge()).reduce(0, (x, y) -> x + y);
         */

        Integer totalAge = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 59),
                new Person("黎明", 52)
        ).map(p -> p.getAge()).reduce(0, Integer::sum); //Integer.sum(int a, int b)

        System.out.println("totalAge = " + totalAge);

        // 找出最大年龄
        Integer maxAge = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 59),
                new Person("黎明", 52)
        ).map(p -> p.getAge()).reduce(0, (x, y) -> x > y ? x : y);
        System.out.println("maxAge = " + maxAge);

        // 统计a出现的次数
        Integer time = Stream.of("a", "b", "c", "a", "d", "a", "e").map(s -> {
            if (s.equals("a")) {
                return 1;
            }
            return 0;
        }).reduce(0, Integer::sum);
        System.out.println("time = " + time);
    }

    @Test
    public void testNumericStream() {
        // Integer占用的内存比int多，在Stream流操作中会自动装箱和拆箱
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        // 把大于3的打印出来
        stream.filter(i -> i.intValue() > 3).forEach(System.out::println);

        // IntStream mapToInt(ToIntFunction<? super T> mapper);
        // IntStream：内部操作的是int类型的数据，就可以节省内存，减少自动装箱
        /*
        IntStream intStream = Stream.of(1, 2, 3, 4, 5).mapToInt((Integer i) -> {
            return i.intValue();
        });
         */
        IntStream intStream = Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue);
        intStream.filter(i -> i > 3).forEach(System.out::println);
    }

    /**
     * <pre>
     *   Stream流的concat方法
     * </pre>
     */
    @Test
    public void testConcat() {
        Stream<String> stream1 = Stream.of("赵");
        Stream<String> stream2 = Stream.of("志成");
        // 合并成一个流
        Stream.concat(stream1, stream2).forEach(System.out::print);
    }
}
