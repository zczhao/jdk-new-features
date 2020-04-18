package demo005stream;

public class Student {

    private String name;
    private Integer age;
    private Integer socre;

    public Student() {
    }

    public Student(String name, Integer age, Integer socre) {
        this.name = name;
        this.age = age;
        this.socre = socre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + ", socre=" + socre + '}';
    }
}
