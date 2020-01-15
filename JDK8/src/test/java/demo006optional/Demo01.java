package demo006optional;

import java.util.Optional;
import org.junit.Test;

public class Demo01 {

    /**
     * 以前对null的处理方式
     */
    @Test
    public void test01() {
        String userName = null;
        if (userName != null) {
            System.out.println("userName = " + userName);
        } else {
            System.out.println("userName is null");
        }
    }

    /**
     * 创建Optional对象
     */
    @Test
    public void test02() {
        // 创建Optional对象
        // of()：只能传入一个具体值，不能传入null
        Optional<String> opl1 = Optional.of("凤姐");
        // Optional<String> opl2 = Optional.of(null);

        // ofNullable()：可以传入具体值，也可以传入null
        Optional<String> opl3 = Optional.ofNullable("如花");
        Optional<String> opl4 = Optional.ofNullable(null);

        // empty()：存入的是null
        Optional<Object> opl5 = Optional.empty();
    }

    /**
     * Optional的基本使用
     */
    @Test
    public void test03() {
        Optional<Object> opl = Optional.of("如花");
        // isPresent：判断Optional中是否有具体值，有值返回true，没有值返回false
        boolean present = opl.isPresent();
        System.out.println("present = " + present);

        // get：获取Optional中的值，如果有值就返回具体值，没有值就报错
        System.out.println(opl.get());
    }

    /**
     * Optional的高级使用
     */
    @Test
    public void test04() {
        //Optional<String> userName0 = Optional.of("凤姐");
        Optional<String> userName0 = Optional.empty();

        // orElse：如果Optional中有值，就取出这个值，如果没有值就使用参数的值
        String name = userName0.orElse("如花吗？");
        System.out.println("name = " + name);
    }

    @Test
    public void test05() {
        // Optional<String> userName0 = Optional.of("凤姐");
        Optional<String> userName0 = Optional.empty();
        // 存在做点什么
        // ifPresent：如果有值就调用参数
        userName0.ifPresent(s -> {
            System.out.println("有值：" + s);
        });

        // 存在做点什么，不存在做点什么 JDK9新增ifPresentOrElse方法 
    }

    @Test
    public void test06() {
        User user = new User("Hello World", 18);
        System.out.println(getUpperUserName01(user));

        Optional<User> opl = Optional.of(user);
        System.out.println(getUpperUserName02(opl));;
    }

    /**
     * 定义一个方法将User中的用户名转成大写并返回,使用传统方式
     *
     * @param user
     * @return
     */
    public static String getUpperUserName01(User user) {
        if (user != null) {
            String userName = user.getUserName();
            if (userName != null) {
                return userName.toUpperCase();
            }
            return null;
        }
        return null;
    }

    /**
     * 定义一个方法将User中的用户名转成大写并返回,使用Optional方式
     *
     * @param opl
     * @return
     */
    public static String getUpperUserName02(Optional<User> opl) {
        //return opl.map(u -> u.getUserName()).map(s -> s.toUpperCase()).orElse("null");
        return opl.map(User::getUserName).map(String::toUpperCase).orElse("null");
    }

}
