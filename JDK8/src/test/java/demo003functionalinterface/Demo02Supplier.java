package demo003functionalinterface;

import java.util.Arrays;
import java.util.function.Supplier;
import org.junit.Test;

public class Demo02Supplier {

    /**
     * 使用Lambda表达式返回数组元素最大值
     */
    @Test
    public void test01() {
        printMax(() -> {
            int[] arr = {11, 99, 77, 88, 22};
            Arrays.sort(arr); // 升序
            return arr[arr.length - 1];
        });
    }

    public static void printMax(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("max = " + max);
    }

}
