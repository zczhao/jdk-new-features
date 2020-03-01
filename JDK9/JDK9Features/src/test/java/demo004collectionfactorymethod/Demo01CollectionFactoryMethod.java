package demo004collectionfactorymethod;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 * 集合工厂方法：创建只读集合的方法，得到的集合是不可变的。
 */
public class Demo01CollectionFactoryMethod {

    /**
     * 工厂方案创建集合
     */
    @Test
    public void test01() {
        List<String> stringList = List.of("a", "b", "c", "d");
        Set<String> stringSet = Set.of("a", "b", "c", "d");
        // of方法重载了0~10对(键值为一对)，超过10对参数,Map需要使用ofEntries方法
        Map<String, Integer> stringIntegerMap1 = Map.of("key1", 1, "key2", 2, "key3", 3);
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(Map.entry("key1", 1), Map.entry("key2", 2), Map.entry("key3", 3));

        System.out.println("stringList " + stringList);
        System.out.println("stringSet " + stringSet);
        System.out.println("stringIntegerMap1 " + stringIntegerMap1);
        System.out.println("stringIntegerMap2 " + stringIntegerMap2);
    }

    @Test
    public void test02() {
        // 工厂可以自由创建新的实例或者复用现有实例，所以 使用 of 创建的集合，避免 == 或者 hashCode 判断操作
        List<String> stringList = List.of("a", "b", "c", "d");
        List<String> stringList2 = List.of("a", "b", "c", "d");
        System.out.println(stringList.hashCode()); // 3910595
        System.out.println(stringList2.hashCode());// 3910595
    }
}
