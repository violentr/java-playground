import java.util.InputMismatchException;
import java.util.Scanner;

public class Basics{
 // public: Anyone can access this
 // static: This belongs to the class, not an instance (important for memory
 // management)

// String[] args : This is an array of strings. This is first point for the
// attacker. Any command line argument passd to the program enters here, If you
// don't validate args, you open the door to injection

  public static void main (String[] args){
    String goal = "Find vulnerabilities";
    try{
      boolean isLearning = true;
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter your age: ");
      int age = scan.nextInt();
      System.out.println("Goal: " + goal);

      if (isLearning){
        System.out.println("User is " + age + " yeaars old and active.");
      }
    }catch(InputMismatchException e){
      System.out.println(e.getMessage());
      System.out.println("Please enter your age !");
    }

  }
}
