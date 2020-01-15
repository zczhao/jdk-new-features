package demo003functionalinterface;

import java.util.function.Predicate;
import org.junit.Test;

public class Demo07Predicate {

    /**
     * 使用Lambda判断一个人名如果超过3个字就认为是很长的名字
     */
    @Test
    public void test01() {
        isLongName((str) -> {
            return str.length() > 3;
        });
    }

    public static void isLongName(Predicate<String> predicate) {
        boolean isLong = predicate.test("迪丽热巴");
        System.out.println("是否是长名字：" + isLong);
    }

}
