 class Person {
    String name;
    int age;

     public Person(String name, int age) {
         this.name = name;
         this.age = age;
     }

     public Person(String name) {
         this.name = name;
     }

     public String hello(){
         if (this.age > 0) {
             return System.out.printf("Hello %s, you are %d years old", this.name, this.age).toString();
         }
         return System.out.printf("Hello %s", this.name).toString();

     }
 }