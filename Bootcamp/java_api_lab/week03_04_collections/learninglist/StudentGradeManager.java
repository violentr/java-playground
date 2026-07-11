package week03_04_collections.learninglist;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentGradeManager {
    private final List<Student> students;
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