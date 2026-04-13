package simple.code.practice;

import java.io.*;

public class FileOperation {
    public void writeToFile(String fileName)  {
        try{
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < 10; i++) {
                writer.write(String.format("Hello World %d\n", i));
            }

            writer.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void readFile(String fileName){
        try{
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.printf("%s %n",line);
            }
            reader.lines().forEach(System.out::println);
        }catch (FileNotFoundException e){
            System.out.printf(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
