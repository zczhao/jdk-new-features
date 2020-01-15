package demo005stream;

import java.util.List;
import org.junit.Test;

public class Demo01ListOf {

    @Test
    public void test01() {
        List<String> list = List.of("乔峰", "段誉", "虚竹", "王语嫣", "阿紫", "阿朱", "慕容复", "段正淳", "康敏");
        list.forEach(System.out::println);
    }
}
