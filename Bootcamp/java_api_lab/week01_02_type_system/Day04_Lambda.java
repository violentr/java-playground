package java_api_lab.week01_02_type_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

class User {
    private String name;
    public User(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
public class Day04_Lambda {
    public static void main(String[] args) {
        List<User> people = new ArrayList<>(Arrays.asList(
                new User("John"), new User("Jane"), new User("Audrey"))
        );
        printAll(people);

        System.out.println("Printing all user's names with stream:");
        people.stream().map(User::getName).forEach(System.out::println);

        System.out.println("Printing all user's names with lambda:");
        people.forEach(p -> System.out.println("Name: " + p.getName()));      // lambda

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 7, 9));
        isEven(list);

        Predicate<Integer> isEven = n -> n % 2 == 0;

        List<Integer> l1 = list.stream()
                .distinct()
                .filter(isEven)
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));
        out.println(l1);

    }
    public static void printAll(List<User> people){
        List <String> names = people.stream()
                /* lambda expression */
                .filter(p -> p.getName().startsWith("J"))
                /* method reference  similar to p -> p.getName() 1st parameter is object*/
                .map(User::getName)
                .toList();
        System.out.println(names);
    }
    public static void isEven(ArrayList<Integer> list){
        /* lambda expression */
        Predicate<Integer> isEven = i -> i % 2 == 0;
        for (int number : list){
            if (isEven.test(number)){
                System.out.printf("%d is even%n", number);
            }
        }
    }

}
