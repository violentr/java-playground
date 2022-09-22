import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;



public class Main {

    public static void main(String arg[]) throws IOException {
        String str = "Hello world!";
        Utility t = new Utility("type");
        t.strOperations(str);
//        int number = printUserNumber();
//        int x[] =new int[number];
//        loop(x);
        t.binOperations();
        t.treeMapOperations();
        t.arrayOperations();
//        int [] a = new int[50000];
//        bubbleSort(a);

//        Person p = new Person("Vasya", 21);
//        p.hello();
//        Musician m = new Musician("James");
//        m.play();

//        String path = String.format("%s/%s", System.getenv("JAVA_PROJECT"), "file.txt");
//        try{
//            String contents = readFile(path);
//            System.out.println(contents);
//        }catch (FileNotFoundException e){
//            System.out.printf("[!]Error: File not found! path: %s\n", path);
//        }

//        t.binaryRepresentation(9);
        // Copy array
        int [] numbers = {1,2,2,4,5,6};
//        int[] moreNumbers = numbers;
        int[] moreNumbers = Arrays.copyOfRange(numbers, 0, numbers.length);

        for(int number: numbers){
            System.out.printf("%d ", number);
        }
    }
}
