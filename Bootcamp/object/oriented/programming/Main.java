package object.oriented.programming;

import help.reverse.challenges.ReverseHelper;

public class Main {
    final static String fileName = "file.txt";

    public static void main(String[] args) {
//        System.out.printf("Writing to file: %s%n", fileName);
//        new FileOperation().writeToFile(fileName);
//        System.out.printf("Reading from file: %s%n", fileName);
//        new FileOperation().readFile(fileName);

        /* Ascii table for characters */
      //  "abcdefghijklmnopqrstuvwxyz\r\n\t".chars().forEach(System.out::println);


        String result = ReverseHelper.hexToAscii("536d6172744861636b546f6f6c73");
        System.out.printf("Result: %s%n", result);

        String original = "Mobisec";
        String hex = ReverseHelper.toHexString(original.getBytes());
        String decoded = ReverseHelper.hexToAscii(hex);
        System.out.println(original.equals(decoded));




//        char c[] = "hello".toCharArray();
//        for (char ch : c) {
//            System.out.printf(" %c", ch);
//        }
    }

}
