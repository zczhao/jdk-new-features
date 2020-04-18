package demo001Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/*
Lambda省略格式：
    1、小括号内参数的类型可以省略
    2、如果小括号内有且仅有一个参数，则小括号可以省略
    3、如果大括号内有且仅有一个语句，可以省略大括号，return关键字及语句分号
 */
public class Demo05LambdaOmit {

    @Test
    public void test01() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 57, 173));
        persons.add(new Person("郭富城", 54, 172));
        persons.add(new Person("黎明", 60, 171));

        Collections.sort(persons, (o1, o2) -> {
            return o2.getAge() - o1.getAge();
        });

        persons.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    public void test02() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 57, 173));
        persons.add(new Person("郭富城", 54, 172));
        persons.add(new Person("黎明", 60, 171));

        Collections.sort(persons, (o1, o2)
                -> o2.getAge() - o1.getAge()
        );

        persons.forEach(p -> System.out.println(p));
    }
}
