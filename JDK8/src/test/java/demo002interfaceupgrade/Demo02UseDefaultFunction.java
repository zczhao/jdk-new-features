package demo002interfaceupgrade;

import org.junit.Test;

/**
 * 接口默认方法的使用
 */
public class Demo02UseDefaultFunction {

    @Test
    public void test01() {
        BB b = new BB();
        b.test01();
    }
    
     @Test
    public void test02() {
        CC c = new CC();
        c.test01();
    }
}

interface AA {

    public default void test01() {
        System.out.println("我是接口AA默认方法");
    }
}

// 默认方法使用方式一：实现类可以直接使用
class BB implements AA {
}

// 默认方法使用方式二：实现类重写接口默认方法
class CC implements AA {

    @Override
    public void test01() {
        System.out.println("我是CC类重写的默认方法");
    }

}
