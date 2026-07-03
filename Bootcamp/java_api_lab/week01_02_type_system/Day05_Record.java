package java_api_lab.week01_02_type_system;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Day05_Record {
    /* record is a new feature in Java 16
     * record is a class that can be used to create immutable objects
     * Record → simple immutable data (name, age, DTO, API response)
     * Class → mutable state, inheritance, lots of behavior
     * */

    record Student(String name, int age) {
        /* no need to write constructor or use its compact syntax
         * for validation
         * */

        public Student {
            if (age < 0) {
                throw new IllegalArgumentException("age must be non-negative");
            }
        }

        public String info() {
            return "name: " + name + ", age: " + age;
        }
    }

    public static void main(String[] args) {
        try{
            Student student3 = new Student("James", -1);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Student student = new Student("John", 23);
        Student student2 = new Student("Carl", 22);

        Student student3 = Optional.ofNullable(student).orElse(new Student("unknown", 0));
        System.out.println("Who is it ? " + student3.name() );
        System.out.println(student.name());
        System.out.println(student.info());

        System.out.println(student.equals(student2));
        System.out.printf("Student: %s%n", student);

        List<Student> students = List.of(student, student2);
        students.stream().map(Student::info).forEach(System.out::println);


    }
    public static Object print(Object object){
        if (object instanceof Student(String name, int age)){
            return object;
        }
        return "unknown";
    }
}
