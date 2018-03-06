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
    private Map<Student, ArrayList<Disciplines>> students;

    public GradeBook() {
        groups = new HashMap<>();
        students = new HashMap<>();
    }

    public void showStudentsGrades(Student student1) {
    }

    public void addStudent(Student student, Disciplines disciplineName) {
        addStudentToStudentList(student, disciplineName);
        addStudentToGroup(student, disciplineName);
    }
    
    private void addStudentToStudentList(Student student, Disciplines disciplineName) {
        if (!students.containsKey(student)) {
            ArrayList<Disciplines> newList = new ArrayList<>();
            newList.add(disciplineName);
            students.put(student, newList);
        } else if (!students.get(student).contains(disciplineName)) {
            students.get(student).add(disciplineName);
        }
    }

    private void addStudentToGroup(Student student, Disciplines disciplineName) {
        if (groups.containsKey(disciplineName)) {
            Group group = groups.get(disciplineName);
            if (!group.isStudentIn(student)) {
                group.addStudent(student);
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
            for (Student student : students.keySet()) {
                stringBuilder.append("Last name: ").append(student.getLastName()).append("  ");
                stringBuilder.append("First name: ").append(student.getFirstName()).append('\n');
            }
            log.info("\nStudents list:\n{}\n", stringBuilder.toString());
        }
    }

    public void showGroupsList() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Disciplines discipline : groups.keySet()) {
                stringBuilder.append(discipline).append('\n');
            }
            log.info("\nGroups list:\n{}\n", stringBuilder.toString());
        }
    }

    public void showDisciplinesStudentAttended(Student student) {
        if (students.containsKey(student)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Disciplines discipline : students.get(student)) {
                stringBuilder.append(discipline).append(" ");
            }
            log.info("{} {}", student.getLastName(), stringBuilder.toString());
        } else
            log.info("This student not in the book yet");
    }

    public void showStudentsGrades(String firstName, String lastName) {
    }

    public void addGrade(String firstName, String lastName, String discipline, int intGrade) {
    }

    public void addGrade(String firstName, String lastName, Disciplines discipline, double doubleGrade) {
    }
}
