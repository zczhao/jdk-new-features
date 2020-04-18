package demo005stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class Demo05 {

    @Test
    public void test01() {
        // 第一个队伍
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "乔峰", "段誉", "虚竹", "王语嫣", "阿紫", "阿朱", "慕容复", "段正淳", "康敏");

        // 第二个队伍
        List<String> two = new ArrayList<>();
        Collections.addAll(two, "张无忌", "赵敏", "周芷若", "宋青书", "杨逍", "殷离", "灭绝师太", "范遥", "谢逊", "张翠山", "张三丰");

        // 1、第一个队伍只要名字为3个字的成员姓名
        // 2、第一个队伍筛选之后只要前3个人
        Stream<String> streamA = one.stream().filter(s -> s.length() == 3).limit(3);

        // 3、第二个队伍只要姓张的成员姓名
        // 4、第二个队伍筛选之后不要前2个人
        Stream<String> streamB = two.stream().filter(s -> s.startsWith("张")).skip(2);

        // 5、将两个队伍合并为一个队伍
        Stream<String> concatStream = Stream.concat(streamA, streamB);
        // 6、根据姓名创建Person对象
        // 7、打印整个队伍的Person对象信息
        concatStream.map(s -> {
            return new Person(s, 18);
        }).forEach(System.out::println);
    }
}
