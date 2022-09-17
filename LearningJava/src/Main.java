import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;



public class Main {
    public static void main(String arg[]){
        String str = "Hello world!";
        strOperations(str);
//        int number = printUserNumber();
//        int x[] =new int[number];
//        loop(x);
        binOperations();
        treeMapOperations();
        arrayOperations();
        int [] a = new int[50000];
        bubbleSort(a);


    }
    public static  void arrayOperations(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
       // while(true) arr.add(1); Check to allocate 100 MB for VM
//        System.out.print("Array contains: " + arr.toString());
    }

    public static void bubbleSort(int[] array){
      /* Bubble sort algorithm */
        for (int i=array.length -1; i>=0 ;i--){
          array[i] = array.length - i;
      }

      long start_time = System.currentTimeMillis();
      long end_time;
      while(true){
          boolean hadPermutations = false;
          for(int i=0;i < array.length -1; i++){
              if(array[i] > array[i+1]) {
                  int q = array[i + 1];
                  array[i + 1] = array[i];
                  array[i] = q;
                  hadPermutations = true;
              }
          }
          if (!hadPermutations) break;

      }
      end_time = System.currentTimeMillis();
      System.out.println("Bubble Sort Algo: It took " + (end_time - start_time)/1000 + "s to sort array with " + array.length + " elements");
    }
    public static void treeMapOperations(){
        TreeMap<Integer, String> t = new TreeMap();
        t.put(121212, "Taxi");
        System.out.println(t.containsValue("Taxi") ? "Taxi" : "N/A");
//        System.out.println(t.get(121212));
    }
    public static void binOperations(){
        int x = 9;
        int range = 1024 * 1024;
        for(int i=0;i<20;i++){
            range = range >>1;
            System.out.print((( x & range ) != 0) ? "1" : "0");
        }
        System.out.println();
    }
    public static void strOperations(String str){
        System.out.printf(str + " !");
        System.out.println(str.substring(6));
        System.out.println(str.length());
    }

    public static void loop(int array[]){
        System.out.println("Array with " + array.length + " elements, array[i] * 10");
        for(int i=0; i< array.length; i++){
            array[i] = i * 10;
        }
        System.out.println(Arrays.toString(array));
    }

    public static int printUserNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        return sc.nextInt();
    }
}
