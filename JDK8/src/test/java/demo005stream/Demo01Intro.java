package demo005stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Demo01Intro {

    /**
     * 需求： 1、拿到所有姓张的 2、拿到所有名字为3个字的 3、打印这些数据
     */
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张三丰");

        // 1、拿到所有姓张的
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        //  2、拿到所有名字为3个字的
        List<String> threeList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                threeList.add(name);
            }
        }
        // 3、打印这些数据
        for (String name : threeList) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张三丰");
        list.stream().filter((s) -> {
            return s.startsWith("张");
        }).filter((s) -> {
            return s.length() == 3;
        }).forEach(System.out::println);
    }
}
