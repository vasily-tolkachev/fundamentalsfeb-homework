package subtasks.five;

import java.util.HashMap;
import java.util.Map;


public class Group {
    private final static boolean intGrades = true;
    private final Map<Student, Integer> studentsGrades;
    private static final int INITIAL_GRADE = 2;

    public Group() {
        studentsGrades = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (!studentsGrades.containsKey(student))
            studentsGrades.put(student, INITIAL_GRADE);
    }


    public void addGrade(Student student, int grade) {
        if (studentsGrades.containsValue(student)) {
            studentsGrades.put(student, grade);
        }
    }

    public boolean isStudentIn(Student student) {
        return studentsGrades.containsKey(student);
    }
}
