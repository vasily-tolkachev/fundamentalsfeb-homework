package subtasks.five;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import subtasks.three.four.Main;

import java.util.HashMap;
import java.util.Map;

class GradeBook {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final int INITIAL_INTEGER_GRADE = 2;
    private static final double INITIAL_DOUBLE_GRADE = 2.0;
    private Map<Integer, Group> groups;

    GradeBook() {
        groups = new HashMap<>();
    }

    void addStudent(Student student, Integer groupId) {
        if (groups.containsKey(groupId)) {
            Group group = groups.get(groupId);
            if (!group.isStudentIn(student)) {
                if (group.getDiscipline().areGradesInteger()) {
                    group.addGrade(student, INITIAL_INTEGER_GRADE);
                } else {
                    group.addGrade(student, INITIAL_DOUBLE_GRADE);
                }
            } else {
                log.info("GradeBook.addStudent A student ID {} {} {} already in group ID {}", student.getStudentId(), student.getLastName(), student.getFirstName(), groupId);
            }
        } else {
            log.info("GradeBook.addStudent The group ID {} doesn't created yet.", groupId);
        }
    }

    void addGroup(Integer groupId, Discipline disciplineName) {
        if (!groups.containsKey(groupId)) {
            groups.put(groupId, new Group(disciplineName));
        } else {
            log.info("GradeBook.addGroup The group with ID {} already exists", groupId);
        }
    }

    void showStudentsInGroups() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                stringBuilder.append("\nGroup ID ").append(entry.getKey()).append(':')
                        .append(entry.getValue().getStudentList());
            }
            log.info("\nStudents in groups: {}\n", stringBuilder.toString());
        }
    }

    void showGroupsList() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                stringBuilder.append("\nID: ")
                        .append(entry.getKey())
                        .append(" Discipline: ")
                        .append(entry.getValue().getDiscipline().name());
            }
            log.info("\nGroups list:{}\n", stringBuilder.toString());
        }
    }

    void showDisciplinesStudentAttended(Student student) {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                if (entry.getValue().isStudentIn(student)) {
                    stringBuilder.append("ID")
                            .append(entry.getKey())
                            .append(" ");
                }
            }
            log.info("\nStudent ID {} attends groups: {}\n", student.getStudentId(), stringBuilder.toString());
        }
    }

    void addGrade(Student student, Integer groupId, Integer grade) {
        Group group = groups.get(groupId);
        if (areGroupAndStudentExist(student, groupId)) {
            if (group.getDiscipline().areGradesInteger()) {
                group.addGrade(student, grade);
            } else {
                log.info("GradeBook.addGrade {} doesn't take integer grade, so {} is inappropriate grade",
                        group.getDiscipline(), grade);
            }
        }
    }

    void addGrade(Student student, Integer groupId, Double grade) {
        Group group = groups.get(groupId);
        if (areGroupAndStudentExist(student, groupId)) {
            if (!group.getDiscipline().areGradesInteger()) {
                group.addGrade(student, grade);
            } else {
                log.info("GradeBook.addGrade {} doesn't take double grade, so {} is inappropriate grade",
                        group.getDiscipline(), grade);
            }
        }
    }

    private boolean areGroupAndStudentExist(Student student, Integer groupId) {
        Group group = groups.get(groupId);
        if (group != null) {
            if (group.isStudentIn(student)) {
                return true;
            } else {
                log.info("GradeBook.addGrade Student ID {} {} {} not in the group ID{}",
                        student.getStudentId(),
                        student.getLastName(),
                        student.getFirstName(),
                        groupId);
            }
        } else {
            log.info("GradeBook.addGrade Group ID {} doesn't exist", groupId);
        }
        return false;
    }

    void showStudentsGrades(Student student) {
        if (!groups.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                Group group = entry.getValue();
                if (group.isStudentIn(student)) {
                    builder.append("\nGroup ID ")
                            .append(entry.getKey())
                            .append(" students grade is ")
                            .append(group.getStudentGrade(student));
                }
            }
            log.info("\nStudent ID {} {} {} grades: {}\n",
                    student.getStudentId(),
                    student.getLastName(),
                    student.getFirstName(),
                    builder.toString());
        }
    }
}
