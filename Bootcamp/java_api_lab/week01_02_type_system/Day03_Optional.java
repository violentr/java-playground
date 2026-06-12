package java_api_lab.week01_02_type_system;


import java.util.Optional;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

public class Day03_Optional {
    public static void demoOrElse() {
        System.out.println("Function: demoOrElse");
        Optional<Person> person = Optional.empty();
        Person p1 = person.orElseGet(() -> new Person("default"));
        System.out.println(p1.getName());
    }

    public static void demoOf() {
        System.out.println("Function: demoOf");
        Person john = new Person("John");
        Optional<Person> person = Optional.of(john);
        System.out.println(person.get().getName());
    }

    public static void demoFilter() {
        System.out.println("Function: demoFilter");
        Optional<Person> person = Optional.of(new Person("John"));
        Optional<Person> p1 = person.filter(p -> p.getName().startsWith("J"));

        if (p1.isEmpty()) {
            System.out.println("Person is empty");
        } else {
            System.out.println(p1.get().getName());
        }
    }

    public static void demoOfNullable() {
        System.out.println("Function: demoOfNullable");
        Person john = null;
        Optional<Person> person = Optional.ofNullable(null);
        String name = person.map(Person::getName).orElse("No name");
        System.out.println(name);
        person.ifPresent(p -> System.out.println(p.getName()));

    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional.get());
        demoOf();
        demoOrElse();
        demoFilter();
        demoOfNullable();
    }
}
