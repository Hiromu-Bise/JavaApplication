public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World");

        Person tarou = new Person("太郎", 20, "man");
        Person hanako = new Person("花子", 22, "woman");

        System.out.println(tarou.getName() + ":" + tarou.getAge() + ":" + tarou.getSex());
        System.out.println(hanako.getName() + ":" + hanako.getAge() + ":" + hanako.getSex());
        System.out.println(Person.getNumber());

    }
}
