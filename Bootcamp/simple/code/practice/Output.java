package simple.code.practice;

import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Output {

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
    public static void calculator(){
        String[] items = {"Bubblegum", "Toffee", "Ice cream", "Milk chocolate", "Doughnut", "Pancake" };
        String[] prices = {"2", "0.2", "5", "4", "2.5", "3.2"};
        String[] quantity = {"101", "590", "450", "420", "430", "25"};
        System.out.println("Earned amount:");
        for (int i = 0; i < items.length; i++) {
            int qty = Integer.parseInt(quantity[i]);
            double unit = Double.parseDouble(prices[i]);
            int price = (int) Math.round(unit * qty);

            System.out.printf("%s: $%d%n", items[i], price);
        }
    }
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int left = str.charAt(i);
            int right = str.charAt(str.length() - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
    /* Restate the problem as finding duplicate number*/
    public static int findDuplicate(int[] numbers) {
        /* Guard clause */
        if (numbers.length == 0) return -1;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        /* loop through the array */
        for (int number : numbers) {
            /* stop the loop if we find a duplicate */
            if (set.contains(number)) {
                result = number;
                break;
            } else {
                set.add(number);
            }
        }
        /* return the duplicate number */
        return result;
    }

    public static boolean isBurgCity(String city){
        return city.endsWith("burg");
    }
    public static void serializeObject(User user, String filename) throws FileNotFoundException, IOException {
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(user);
            out.close();
            file.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deserializeObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            User object = (User) in.readObject();
            in.close();
            file.close();
            System.out.printf("User: %s%n", object.getName());
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
