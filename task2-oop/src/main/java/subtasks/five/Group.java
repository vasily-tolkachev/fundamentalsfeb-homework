package subtasks.five;

import java.util.HashMap;
import java.util.Map;


public class Group {
    private Map<Student, Integer> studentsGrades;
    private static final int INITIAL_GRADE = 2;
    private final Discipline discipline;

    Group(Discipline discipline) {
        this.discipline = discipline;
        studentsGrades = new HashMap<>();
    }

    void addGrade(Student student, Integer grade) {
        studentsGrades.put(student, grade);
    }

    Integer getStudentGrade(Student student) {
        return studentsGrades.get(student);
    }

    String getStudentList() {
        StringBuilder builder = new StringBuilder();
        for (Student student : studentsGrades.keySet()) {
            builder.append("\nStudent ID ")
                    .append(student.getStudentId())
                    .append(" ")
                    .append(student.getFirstName())
                    .append(" ")
                    .append(student.getLastName());
        }
        return builder.toString();
    }

    void addStudent(Student student) {
        if (!studentsGrades.containsKey(student))
            studentsGrades.put(student, INITIAL_GRADE);
    }

    boolean isStudentIn(Student student) {
        return studentsGrades.containsKey(student);
    }

    Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "Group{" +
                "discipline=" + discipline +
                '}';
    }
}
