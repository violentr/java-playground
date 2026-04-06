package simple.code.practice;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User implements Serializable {
    /* Serializable is a marker interface */
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

class Output {
    public void go() {
        int y = 7;
        for (int x = 1; x < 8; x++) {
            y++;
            if (x > 4) {
                System.out.printf("%d %n", ++y);
            }
            if (y > 14) {
                System.out.printf("x = %d%n", x);
                break;
            }
        }
    }

    public void loop(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.printf("Char: %s ", str.charAt(i));
        }
    }

    public void test_method(String s) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nPlease enter your age: ");
            int age = scan.nextInt();
            System.out.printf("Goal: %s%n", s);
            System.out.printf("User is %d years old and active.%n", age);

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter your age !");
        }
    }
}