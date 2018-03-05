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
    private Map<String, String> students;

    public GradeBook() {
        groups = new HashMap<>();
        students = new HashMap<>();
    }

    public void showStudentsGrades(Student student1) {
    }

/*    public void addStudent(Student student) {
        if (!freeStudents.contains(student))
            freeStudents.add(student);
        else
            log.info("Students list already contains this name {} {}", student.getLastName(), student.getFirstName());
    }*/

    public void addStudent(Student student, Disciplines disciplineName) {
        if (groups.containsKey(disciplineName)) {
            Group group = groups.get(disciplineName);
            if (!group.isStudentIn(student)) {
                group.addStudent(student);
                if (!students.containsKey(students.containsKey(student.getLastName()))) {
                    students.put(student.getLastName(), student.getFirstName());
                }
            } else {
                log.info("A student {} {} already in {} group", student.getLastName(), student.getFirstName(), disciplineName);
            }
        } else {
            log.info("The group {} doesn't created yet.", disciplineName);
        }
    }

    public void addNewGroup(Disciplines disciplineName) {
        if (!groups.containsKey(disciplineName)) {
            groups.put(disciplineName, new Group());
        }
    }

    public void showStudentsList() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!students.isEmpty()) {
            for (String surname : students.keySet()) {
                stringBuilder.append("Last name: ").append(surname).append("  ");
                stringBuilder.append("First name: ").append(students.get(surname)).append('\n');
            }
            log.info("\nStudents list:\n{}\n", stringBuilder.toString());
        }
    }

    public void showDisciplinesList() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Disciplines discipline : groups.keySet()) {
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
