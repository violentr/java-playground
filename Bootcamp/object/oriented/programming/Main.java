package object.oriented.programming;

import simple.code.practice.Network;
import simple.code.practice.User;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//      /* descending order */
//        boolean result = isPalindrome("racccar");
//        System.out.printf("isPalindrome: %s%n", result ? "True" : "False");
//        int[] numbers = new int[]{1, 2, 3, 3, 4, 5};
//        System.out.printf("Duplicate found: %d%n", findDuplicate(numbers));
//        String text = "hello world";
//        System.out.printf("text: %c%n", text.equalsIgnoreCase("hello wOrlD") ? 'T' : 'F');
       /*
        User user = new User("James", 25);
        String filename = "user.ser";
        serializeObject(user, filename);
        deserializeObject(filename);
        */
       Network nwt = new Network("https://www.google.com");
       nwt.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/120.0.0.0");
       nwt.makeHTTPRequest();

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
