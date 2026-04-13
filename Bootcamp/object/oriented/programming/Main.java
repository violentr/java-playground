package object.oriented.programming;

import simple.code.practice.FileOperation;
import simple.code.practice.Output;
import simple.code.practice.User;

import java.io.*;
import java.util.HashSet;

public class Main {
    final static String fileName = "file.txt";

    public static void main(String[] args) {
        System.out.printf("Writing to file: %s%n", fileName);
        new FileOperation().writeToFile(fileName);
        System.out.printf("Reading from file: %s%n", fileName);
        new FileOperation().readFile(fileName);

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
