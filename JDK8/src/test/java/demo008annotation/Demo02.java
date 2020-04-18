package demo008annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 类型注解的使用
 */
public class Demo02<@TypeParam T> {

    private @NotNull int a = 10;

    public <@TypeParam E extends Integer> void test01() {

    }

    public void test02(@NotNull String str, @NotNull int a) {
        @NotNull double d = 10.1;
    }

}

// TYPE_PARAMETER：表示该注解能写在类型参数的声明语句中。类型参数声明如：<T>、<T extends Person>
@Target(ElementType.TYPE_PARAMETER)
@interface TypeParam {

}

// TYPE_USE：表示该注解可以在任何用到类型的地方使用
@Target(ElementType.TYPE_USE)
@interface NotNull {

}
