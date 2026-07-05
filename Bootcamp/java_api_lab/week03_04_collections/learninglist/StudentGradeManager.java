package week03_04_collections.learninglist;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


/*
Task: Student Grade Manager with ArrayList
The Goal: Build a class that manages students and their grades using ArrayList operations.

Core Operations You'll Practice:
add() / remove() — managing students
get() / size() — accessing elements
indexOf() / finding specific students
Iterating through lists

Combining operations (filter a student's grades, remove specific ones)
Why This Task?
•
Tests if you can use ArrayList in a realistic scenario (not just "add 3 items")
Forces you to combine multiple operations (add student → add grades → calculate average)
Covers the main operations you need to know by Week 4

Bonus Challenge:
Use Streams for calculating averages (combines what you're learning!)
Sort students or grades
 */

public class StudentGradeManager {
    private final ArrayList<Student> students;
    public StudentGradeManager() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
        this.students.remove(student);
    }
    public int indexOfStudent(Student student) {
        return this.students.indexOf(student);
    }

    public double getAverageGrade(Student student){
        Objects.requireNonNull(student, "Student cannot be null");
        return student.getGrades().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void removeLowestGrade(Student student){
        Objects.requireNonNull(student, "Student cannot be null");
        if (student.getGrades().isEmpty()) {
            throw new IllegalStateException("No grades to remove");
        }
        int lowestGrade = student.getGrades().stream().min(Integer::compare).orElseThrow();
        System.out.println("Removing lowest grade: " + lowestGrade);
        student.removeGrade(lowestGrade);
    }
    public void printAllStudents(){
        System.out.println("All Students:");
         this.students.stream()
                .map(Student::getStudentName)
                .forEach(e -> System.out.println("- " + e));
    }

    public Optional<Student> getStudentByName(String name){
        return this.students.stream()
                .filter(student -> student.getStudentName().equals(name))
                .findFirst();
    }

    public Student getStudent(int index) {
        return this.students.get(index);
    }
    public int getStudentCount() {
        return this.students.size();
    }

}