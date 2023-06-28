public class Person {
    private static int number; //人数
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        number++;
    }

    public static int getNumber() {
        return number;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getSex() {
        return this.sex;
    }


}