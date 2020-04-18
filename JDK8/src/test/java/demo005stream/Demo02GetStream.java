package demo005stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;

public class Demo02GetStream {

    /**
     * 1、根据Collection获取流
     *  Collection接口中有一个默认的方法：default Stream<E> stream()
     */
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();
     
        Map<String,String> map = new HashMap<>();
        Stream<String> stream3 = map.keySet().stream();
        Stream<String> stream4 = map.values().stream();
        Stream<Map.Entry<String, String>> stream5 = map.entrySet().stream();
    }
    
    /**
     * 2、Stream中的静态方法of获取流
     *  public static<T> Stream<T> of(T... values)
     */
    @Test
    public void test02() {
        Stream<String> stream1 = Stream.of("张无忌", "周芷若", "赵敏", "张三丰");
        String[] strs = {"张无忌", "周芷若", "赵敏", "张三丰"};
        Stream<String> stream2 = Stream.of(strs);
        
        // 基本数据类型的数组是不行的，会将整个数组看做一个元素进行操作
        int[] arr = {11, 22, 33};
        Stream<int[]> stream3 = Stream.of(arr);
    }
}
