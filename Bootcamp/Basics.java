public class Basics{
 // public: Anyone can access this
 // static: This belongs to the class, not an instance (important for memory
 // management)

// String[] args : This is an array of strings. This is first point for the
// attacker. Any command line argument passd to the program enters here, If you
// don't validate args, you open the door to injection

  public static void main (String[] args){
    int age = 25;
    String goal = "Find vulnerabilities";
    boolean isLearning = true;

    System.out.println("Goal: " + goal);

    if (isLearning){
      System.out.println("User is " + age + " yeaars old and active.");
    }
  }
}
