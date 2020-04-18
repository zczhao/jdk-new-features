package demo006optional;

import java.util.Optional;
import org.junit.Test;

public class Demo02 {

    @Test
    public void test01() {
        User user = new User();
        user.setName("zzc");

        // user.getAddress().getProvince();
        // 这种写法，在user为null时，是有可能报NullPointerException异常的。为了解决这个问题，于是采用下面的写法
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String province = address.getProvince();
                System.out.println("province=" + province);
            }
        }
        

        String province = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElse("");
        System.out.println("province=" + province);

    }

    /**
     * 1、Optional(T value),empty(),of(T value),ofNullable(T value)
     */
    @Test
    public void test02() {
        // 1、Optional(T value)，即构造函数，它是private权限的，不能由外部调用的。其余三个函数是public权限，供我们所调用。Optional的本质，就是内部储存了一个真实的值，在构造的时候，就直接判断其值是否为空。

        // 2、of(T value)
        //   2.1、通过of(T value)函数所构造出的Optional对象，当Value值为空时，依然会报NullPointerException。
        //   2.2、通过of(T value)函数所构造出的Optional对象，当Value值不为空时，能正常构造Optional对象。
        // 3、empty（）的作用就是返回EMPTY对象。
        // 4、ofNullable(T value)
        //   相比较of(T value)的区别就是，当value值为null时，of(T value)会报NullPointerException异常；ofNullable(T value)不会throw Exception，ofNullable(T value)直接返回一个EMPTY对象。
    }

    @Test
    public void test03_1() {
        User user = null;
        user = Optional.ofNullable(user).orElse(createUser());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());

    }

    public User createUser() {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    /**
     * 2、orElse(T other)，orElseGet(Supplier<? extends T> other) 和 orElseThrow(Supplier<? extends X> exceptionSupplier)
     */
    @Test
    public void test03_2() throws Exception {
        // 都是在构造函数传入的value值为null时，进行调用的。orElse和orElseGet的用法如下所示，相当于value值为null时，给予一个默认值
        // 这两个函数的区别：当user值不为null时，orElse函数依然会执行createUser()方法，而orElseGet函数并不会执行createUser()方法

        // orElseThrow，就是value值为null时,直接抛一个异常出去
        User user = null;
        Optional.ofNullable(user).orElseThrow(() -> new Exception("用户不存在"));
    }
    
    /**
     * 3、map(Function<? super T, ? extends U> mapper) 和 flatMap(Function<? super T, Optional<U>> mapper)
     */
    @Test
    public void test04() {
        // 两个函数做的是转换值的操作
        // 这两个函数，在函数体上没什么区别。唯一区别的就是入参，map函数所接受的入参类型为Function<? super T, ? extends U>，而flapMap的入参类型为Function<? super T, Optional<U>>

        User user = null;
        String name = Optional.ofNullable(user).map(u -> u.getName()).get();
        System.out.println("name=" + name);
        
        /*
        public class User {
            private String name;
            public Optional<String> getName() {
                return Optional.ofNullable(name);
            }
        }
        
        // 这时候取name的写法如下所示
        String city = Optional.ofNullable(user).flatMap(u-> u.getName()).get();
        
        */
    }
    
    
    /**
     * 4、isPresent()和ifPresent(Consumer<? super T> consumer)
     */
    @Test
    public void test05() {
        // isPresent即判断value值是否为空，而ifPresent就是在value值不为空时，做一些操作。
        
        /*
        // 需要额外说明的是，大家千万不要把
        if (user != null){
            // TODO: do something
         }
        
        // 给写成
        User user = Optional.ofNullable(user);
        if (Optional.isPresent()){
           // TODO: do something
        }
        
        正确写法ifPresent(Consumer<? super T> consumer)
        Optional.ofNullable(user).ifPresent(u->{
            // TODO: do something
        });
        */
    }
    
    /**
     * 5、filter(Predicate<? super T> predicate)
     */
    @Test
    public void test06() {
        // filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty
        /*
            Optional<User> user1 = Optional.ofNullable(user).filter(u -> u.getName().length()<6);
        */
    }

    
    /**
     * 以前写法
     * @param user
     * @return
     * @throws Exception 
     */
    public String getCity_01(User user) throws Exception {
        if (user != null) {
            if (user.getAddress() != null) {
                Address address = user.getAddress();
                if (address.getCity() != null) {
                    return address.getCity();
                }
            }
        }
        throw new Exception("取值错误");
    }
    
    /**
     * Java8写法
     * @param user
     * @return
     * @throws Exception 
     */
    public String getCity_02(User user) throws Exception {
        return Optional.ofNullable(user)
                .map(u -> u.getAddress())
                .map(a -> a.getCity())
                .orElseThrow(() -> new Exception("取指错误"));
    }
    
    /*
        // 以前写法
        if(user!=null){
            dosomething(user);
        }
    
        // JAVA8写法
        Optional.ofNullable(user).ifPresent(u->{
                dosomething(u);
        });
    */
    
    /**
     * 以前写法
     * @param user
     * @return
     * @throws Exception 
     */
    public User getUser_01(User user) throws Exception {
        if (user != null) {
            String name = user.getName();
            if ("zhangsan".equals(name)) {
                return user;
            }
        } else {
            user = new User();
            user.setName("zhangsan");
            return user;
        }
        return null;
    }
    
    /**
     * JAVA8写法
     * @param user
     * @return 
     */
    public User getUser_02(User user) {
        return Optional.ofNullable(user)
                .filter(u -> "zhangsan".equals(u.getName()))
                .orElseGet(() -> {
                    User user1 = new User();
                    user1.setName("zhangsan");
                    return user1;
                });
    }
    
    
}


