package subtasks.five;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import subtasks.three.four.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GradeBook {
    private static final Logger log = LogManager.getLogger(Main.class);
    private Map<Disciplines, Group> groups;
    private ArrayList<Student> freeStudents;

    public GradeBook() {
        groups = new HashMap<>();
        freeStudents = new ArrayList<>();
    }

    public void showStudentsGrades(Student student1) {
    }

    public void addStudent(String firstName, String lastName) {
        freeStudents.add(new Student(firstName, lastName));
    }

    public void assignStudentToDiscipline(String firstName, String lastName, Disciplines disciplineName) {
    }

    public void addNewGroup(Disciplines disciplineName) {
        if (!groups.containsKey(disciplineName)) {
            groups.put(disciplineName, new Group(disciplineName));
        }
    }

    public void showStudentsList() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!freeStudents.isEmpty()) {
            for (Student student : freeStudents) {
                stringBuilder.append("Last name: ").append(student.getLastName()).append("  ");
                stringBuilder.append("First name: ").append(student.getFirstName()).append('\n');
            }
            log.info("\nStudents list:\n{}\n", stringBuilder.toString());
        }
    }

    public void showDisciplinesList() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Disciplines discipline: groups.keySet()) {
                stringBuilder.append(discipline).append('\n');
            }
            log.info("\nGroups list:\n{}\n", stringBuilder.toString());
        }
    }

    public void showDisciplinesStudentAttendend(String firstName, String lastName) {
    }

    public void showStudentsGrades(String firstName, String lastName) {
    }

    public void addGrade(String firstName, String lastName, String discipline, int intGrade) {
    }

    public void addGrade(String firstName, String lastName, Disciplines discipline, double doubleGrade) {
    }
}
