package demo005stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Demo06Collect {

    /**
     * 将流中数据收集到集合中
     */
    @Test
    public void testStreamToCollection01() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 收集到List
        List<String> list = stream.collect(Collectors.toList());
        System.out.println("list = " + list);

    }

    @Test
    public void testStreamToCollection02() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 收集到Set
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println("set = " + set);
    }

    @Test
    public void testStreamToCollection03() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 收集到指定的集合中ArrayList
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("arrayList = " + arrayList);
    }

    @Test
    public void testStreamToCollection04() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "bb");
        // 收集到指定的集合中HashSet
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println("hashSet = " + hashSet);
    }

    /**
     * 将流中的数据收集到数组中
     */
    @Test
    public void testStreamToArray01() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 转成Object数组
        Object[] objects = stream.toArray();
        System.out.println("objects = " + Arrays.toString(objects));
    }

    @Test
    public void testStreamToArray02() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 转成String数组
        String[] strings = stream.toArray(String[]::new);
        System.out.println("strings = " + Arrays.toString(strings));
    }

    /**
     * 其他收集流中数据的方式(相当于数据库中的聚合函数)
     */
    @Test
    public void testStreamToOther01() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );
        // 获取成绩最高的学生
        Optional<Student> max = studentStream.collect(Collectors.maxBy((s1, s2) -> s1.getSocre() - s2.getSocre()));
        System.out.println("max = " + max.get());
    }

    @Test
    public void testStreamToOther02() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );

        // 获取成绩最低的学生
        Optional<Student> min = studentStream.collect(Collectors.minBy((s1, s2) -> s1.getSocre() - s2.getSocre()));
        System.out.println("min = " + min.get());
    }

    @Test
    public void testStreamToOther03() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );

        // 获取成绩总和
        // Integer sum = studentStream.collect(Collectors.summingInt(s -> s.getSocre()));
        Integer sum = studentStream.collect(Collectors.summingInt(Student::getSocre));
        System.out.println("sum = " + sum);
    }

    @Test
    public void testStreamToOther04() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );

        // 获取成绩平均值
        //Double agv = studentStream.collect(Collectors.averagingInt(s -> s.getSocre()));
        Double agv = studentStream.collect(Collectors.averagingInt(Student::getSocre));
        System.out.println("agv = " + agv);
    }

    @Test
    public void testStreamToOther05() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77)
        );

        // 统计学生个数
        Long count = studentStream.collect(Collectors.counting());
        System.out.println("count = " + count);
    }

    /**
     * 分组
     */
    @Test
    public void testGroup01() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 根据年龄分组
        Map<Integer, List<Student>> map = studentStream.collect(Collectors.groupingBy(Student::getAge));
        map.forEach((k, v) -> {
            System.out.println(k + "::" + v);
        });
    }

    @Test
    public void testGroup02() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 将分数大于60的分为一组，小于60的分为另一组
        Map<String, List<Student>> map = studentStream.collect(Collectors.groupingBy(s -> {
            if (s.getSocre() > 60) {
                return "及格";
            }
            return "不及格";
        }));
        map.forEach((k, v) -> {
            System.out.println(k + " :: " + v);
        });
    }

    /**
     * 多级分组
     */
    @Test
    public void testGroup03() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 先根据年龄分组，每组中再根据成绩分组
        // Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
        Map<Integer, Map<String, List<Student>>> map = studentStream.collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(s -> {
            if (s.getSocre() > 60) {
                return "及格";
            }
            return "不及格";
        })));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k2, v2) -> {
                System.out.println("\t" + k2 + " == " + v2);
            });
        });
    }

    /**
     * 分区
     */
    @Test
    public void testPartition() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 按成绩
        Map<Boolean, List<Student>> map = studentStream.collect(Collectors.partitioningBy(s -> s.getSocre() > 60));
        map.forEach((k, v) -> {
            System.out.println(k + " :: " + v);
        });
    }

    /**
     * 拼接
     */
    @Test
    public void testJoining01() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 姓名拼接-根据一个字符串拼接
        String str = studentStream.map(Student::getName).collect(Collectors.joining(","));
        System.out.println("str = " + str);
    }

    @Test
    public void testJoining02() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 55),
                new Student("柳岩", 52, 33)
        );

        // 姓名拼接-根据三个字符串拼接
        String str = studentStream.map(Student::getName).collect(Collectors.joining(",", "^_^", "^_^"));
        System.out.println("str = " + str);
    }
}
