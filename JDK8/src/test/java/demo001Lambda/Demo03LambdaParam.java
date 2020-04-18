package demo001Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo03LambdaParam {

    @Test
    public void test01() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 57, 173));
        persons.add(new Person("郭富城", 54, 172));
        persons.add(new Person("黎明", 60, 171));

        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        for (Person person : persons) {
            System.out.println(person);
        }
    }
    
    @Test
    public void test02() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 57, 173));
        persons.add(new Person("郭富城", 54, 172));
        persons.add(new Person("黎明", 60, 171));

        Collections.sort(persons, (Person o1, Person o2) -> {
            return o2.getAge() - o1.getAge();
        });

        for (Person person : persons) {
            System.out.println(person);
        }
    }
    
}
