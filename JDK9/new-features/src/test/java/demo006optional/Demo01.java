package demo006optional;

import java.util.Optional;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test01() {
        // Optional<String> userName0 = Optional.of("凤姐");
        Optional<String> userName0 = Optional.empty();
        // 存在做点什么
        // ifPresent：如果有值就调用参数
        userName0.ifPresent(s -> {
            System.out.println("有值：" + s);
        });

        // 存在做点什么，不存在做点什么
        userName0.ifPresentOrElse(s -> {
            System.out.println("有值：" + s);
        }, () -> {
            System.out.println("没有值");
        });
    }
}
