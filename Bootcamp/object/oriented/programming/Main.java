package object.oriented.programming;

import help.reverse.challenges.ReverseHelper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    final static String fileName = "file.txt";

    public static void main(String[] args) {
//        System.out.printf("Writing to file: %s%n", fileName);
//        new FileOperation().writeToFile(fileName);
//        System.out.printf("Reading from file: %s%n", fileName);
//        new FileOperation().readFile(fileName);

        /* Ascii table for characters */
      //  "abcdefghijklmnopqrstuvwxyz\r\n\t".chars().forEach(System.out::println);

        try {
            String str = "732901";
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] data = str.getBytes(StandardCharsets.UTF_8);
            md.update(data);
            byte[] digest = md.digest();
            System.out.println("MD5 Hash: "+ ReverseHelper.toHexString(digest));

        }catch (NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }



//        char c[] = "hello".toCharArray();
//        for (char ch : c) {
//            System.out.printf(" %c", ch);
//        }
    }

}
