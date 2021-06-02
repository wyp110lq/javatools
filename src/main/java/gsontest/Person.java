package gsontest;

/**
 * 类GsonTest.java的实现描述：TODO 类实现描述
 * @author riqi 2013年8月5日 下午10:26:28
 */

class Person {

    private String name;

    private int    age;

    private Family family;

    public Person(String name, int age, Family family) {
        super();
        this.name = name;
        this.age = age;
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", family=" + family + "]";
    }
}