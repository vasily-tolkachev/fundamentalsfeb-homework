package subtasks.five;

import java.util.HashMap;
import java.util.Map;


public class Group<N> {
    private Map<Student, N> studentsGrades;
    private final Discipline discipline;

    Group(Discipline discipline) {
        this.discipline = discipline;
        studentsGrades = new HashMap<>();
    }

    void addGrade(Student student, N grade) {
        studentsGrades.put(student, grade);
    }

    N getStudentGrade(Student student) {
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
