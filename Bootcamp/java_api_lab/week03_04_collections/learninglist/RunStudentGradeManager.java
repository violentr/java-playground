package week03_04_collections.learninglist;

import java.util.List;
import java.util.Optional;

public class RunStudentGradeManager {
    public static void main(String[] args) {
        StudentGradeManager manager = new StudentGradeManager();
        Student john = new Student("John");
        john.addGrade(90);
        john.addGrade(80);
        john.addGrade(70);

        Student jane = new Student("Jane");
        jane.addGrade(85);
        jane.addGrade(75);
        jane.addGrade(65);

        Student bob = new Student("Bob");
        for (Student s : List.of(john, jane, bob)) {
            manager.addStudent(s);
        }
        System.out.println("All Students:" + manager.getStudentCount());
        System.out.println("Remove John's lowest grade");
        manager.removeLowestGrade(john);
        /* Edge case */
        //manager.removeLowestGrade(bob);
        double bobGrades = manager.getAverageGrade(bob);
        System.out.println("Bob's average grade is: " + bobGrades);
        manager.removeStudent(john);
        System.out.println("After removing John: " + manager.getStudentCount());
        System.out.println("Jane is at index" + manager.indexOfStudent(jane) + " in the list.");

        System.out.println("Jane's average grade is:" + manager.getAverageGrade(jane));
        System.out.println("Jane's average grade after removing lowest grade is:" + manager.getAverageGrade(jane));
        manager.printAllStudents();
        /* returns void can't be assigned to the variable
        * Just prints name
        * Better use for side effects not for returning values
        * Logging, Saving, Updating, calling method on the object
        * setting the field, sending notification, etc.
        *  */
        manager.getStudentByName("Jane").ifPresent(s -> System.out.println("Found by Name: " + s.getStudentName()));
        /* Use map when want to save the return object */

        String name = manager.getStudentByName("Jane").map(Student::getStudentName).orElse("No name");
        System.out.println("Student's name is : " + name);
    }
}