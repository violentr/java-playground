package object.oriented.programming;

import help.reverse.challenges.ReverseHelper;

import java.nio.charset.StandardCharsets;

public class Main {
    final static String fileName = "file.txt";

    public static void main(String[] args) {
//        System.out.printf("Writing to file: %s%n", fileName);
//        new FileOperation().writeToFile(fileName);
//        System.out.printf("Reading from file: %s%n", fileName);
//        new FileOperation().readFile(fileName);

        /* Ascii table for characters */
      //  "abcdefghijklmnopqrstuvwxyz\r\n\t".chars().forEach(System.out::println);


        //String result = ReverseHelper.hexToAscii("536d6172744861636b546f6f6c73");
        //System.out.printf("Result: %s%n", result);

//        String original = "Mobisec";
//        String hex = ReverseHelper.toHexString(original.getBytes());
//        String decoded = ReverseHelper.hexToAscii(hex);
//        System.out.println(original.equals(decoded));
//        String result = xorDecode("1304160411   ", 0x73);
//        System.out.println(result);

// Let's encrypt it

        String decoded = ReverseHelper.xorDecode("391a121c1b", 0x75);
        System.out.println(decoded);
        System.out.println(ReverseHelper.xorEncode("Login", 0x75));

//        char c[] = "hello".toCharArray();
//        for (char ch : c) {
//            System.out.printf(" %c", ch);
//        }
    }


}
