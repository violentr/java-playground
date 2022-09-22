import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Utility {
    private String entity;

    public Utility(String item){
        this.entity = item;
    }
    public void binaryRepresentation(int number){
        System.out.printf("Binary representation of number=%d is %s", number, Integer.toBinaryString(number));
    }
    public boolean compareArrays(int[] array, int[] array2){
        Boolean value = true;

        for(int i=0;i<array.length;i++){
            if (array[i] != array2[i]) {
                value = false;
            }else {
                value = true;
            }
        }
        return value;
    }

    public int[] copyArrays(int[] array){
        return Arrays.copyOfRange(array, 0, array.length);
    }
    public static String readFile(String path) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(path));
        String contents;

        try{
            StringBuilder sb = new StringBuilder();
            String line = buffer.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = buffer.readLine();
            }
            contents = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            buffer.close();
        }
        return contents;
    }

    public   void arrayOperations(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        // while(true) arr.add(1); Check to allocate 100 MB for VM
//        System.out.print("Array contains: " + arr.toString());
    }

    public  void bubbleSort(int[] array){
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
    public  void treeMapOperations(){
        TreeMap<Integer,String> t = new TreeMap();
        t.put(121212, "Taxi");
        System.out.println(t.containsValue("Taxi") ? "Taxi" : "N/A");
//        System.out.println(t.get(121212));
    }
    public  void binOperations(){
        int x = 9;
        int range = 1024 * 1024;
        for(int i=0;i<20;i++){
            range = range >>1;
            System.out.print((( x & range ) != 0) ? "1" : "0");
        }
        System.out.println();
    }
    public  void strOperations(String str){
        System.out.printf(str + " !");
        System.out.println(str.substring(6));
        System.out.println(str.length());
    }

    public  void loop(int array[]){
        System.out.println("Array with " + array.length + " elements, array[i] * 10");
        for(int i=0; i< array.length; i++){
            array[i] = i * 10;
        }
        System.out.println(Arrays.toString(array));
    }

    public int printUserNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        return sc.nextInt();
    }
}
