class ForLoop{

  public static void arrayExample(){
    String array[] = {"Ron", "Harry", "Hermoine"};
    for (int i = 0; i < array.length; i++)
    // for (String x:array)
      {
        // System.out.println(x);
        System.out.println(array[i]);
      }
  }

  public static void example(){
    int n = 10, result = 1;
    for (int j = 1 ; j <= n; j++){
      String debug = String.format("result * j or %s * %s = %s ", result, j, (result* j) );
      System.out.println(debug);
      result = result * j;
    }
    System.out.println("Your result = " + result);
  }
  public static void main(String args[]){
    arrayExample();
    example();
  }
}
