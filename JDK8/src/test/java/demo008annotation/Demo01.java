package demo008annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.Test;

/**
 * 重复注解的使用
 */
// 3、配置重复注解
@MyTest("ta")
@MyTest("tb")
@MyTest("tc")
public class Demo01 {
    
    @Test
    @MyTest("ma")
    @MyTest("mb")
    public void test() {
        
    }
    public static void main(String[] args) throws NoSuchMethodException {
        // 4、解析重复注解
        
        // 获取类上的重复注解
        // getAnnotationsByType：是新增的API用于获取重复的注解
        MyTest[] myTests1 = Demo01.class.getAnnotationsByType(MyTest.class);
        for (MyTest myTest : myTests1) {
            System.out.println(myTest);
        }
        System.out.println("------------------------------------------------------------------------");
        // 获取方法上的重复注解
        MyTest[] myTests2 = Demo01.class.getMethod("test").getAnnotationsByType(MyTest.class);
        for (MyTest myTest : myTests2) {
            System.out.println(myTest);
        }
    }
}

// 1、定义重复的注解容器注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyTests {

    MyTest[] value();
}

// 2、定义一个可以重复的注解
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyTests.class)
@interface MyTest {

    String value();
}
