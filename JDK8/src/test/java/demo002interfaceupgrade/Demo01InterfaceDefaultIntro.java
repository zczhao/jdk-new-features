package demo002interfaceupgrade;

public class Demo01InterfaceDefaultIntro {

}

interface A {

    public abstract void test01();
    // 所有实现类都需要实现这个方法，工程量巨大
    // JDK8为接口新增了默认方法，接口中的默认方法实现类不必重写，可以直接使用，实现类也可以根据需要重写，这样就方便接口的扩展
    // public abstract void test02();
    /*
    接口默认方法的定义格式：
        修饰符 default 返回值类型 方法名() {
            代码;
        }
    接口默认方法的使用：
        1、实现类直接调用接口默认方法
        2、实现类重写接口默认方法
    */
}

class B implements A {

    @Override
    public void test01() {
        System.out.println("B implements A -> test01()");
    }
}

class C implements A {

    @Override
    public void test01() {
        System.out.println("C implements A -> test01()");
    }
}
