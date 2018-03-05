package subtasks.five;

import java.util.HashMap;
import java.util.Map;


public class Group {
    private final Disciplines disciplineName;
    private final Map<Student, Integer> studentsGrades;
    private static final int INITIAL_GRADE = 2;

    public Group(Disciplines disciplineName) {
        this.disciplineName = disciplineName;
        studentsGrades = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentsGrades.put(student, INITIAL_GRADE);
    }

    public void addGrade(Student student, int grade) {
        if (studentsGrades.containsValue(student)) {
            studentsGrades.put(student, grade);
        }
    }

    public Disciplines getDisciplineName() {
        return disciplineName;
    }
}
