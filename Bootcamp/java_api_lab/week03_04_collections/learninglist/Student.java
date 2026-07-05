package week03_04_collections.learninglist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getStudentName() {
        return name;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public List<Integer> getGrades() {
        /* return unmodifiable collection of grades;
        * protects the collection from modification
        * like this.grades.clear()
        * */
        return Collections.unmodifiableList(grades);
    }

    public void removeGrade(int grade) {
        /* remove grade from the list
        Wrong, as it will remove by index of the grade, not the grade itself
        * this.grades.remove(grade);
        * that is why need to convert grade to Integer
        * */
        this.grades.remove(Integer.valueOf(grade));
    }
}
