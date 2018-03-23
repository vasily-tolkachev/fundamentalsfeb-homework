package subtasks.five;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import subtasks.three.four.Main;
import java.util.HashMap;
import java.util.Map;

class GradeBook {
    private static final Logger log = LogManager.getLogger(Main.class);
    private Map<Integer, Group> groups;

    GradeBook() {
        groups = new HashMap<>();
    }

    void addStudent(Student student, Integer groupId) {
        if (groups.containsKey(groupId)) {
            Group group = groups.get(groupId);
            if (!group.isStudentIn(student)) {
                group.addStudent(student);
            } else {
                log.info("A student ID {} {} {} already in group ID {}", student.getStudentId(), student.getLastName(), student.getFirstName(), groupId);
            }
        } else {
            log.info("The group ID {} doesn't created yet.", groupId);
        }
    }

    void addNewGroup(Integer groupId, Discipline disciplineName) {
        if (!groups.containsKey(groupId)) {
            groups.put(groupId, new Group(disciplineName));
        }
        else {
            log.info("The group with ID {} already exists", groupId);
        }
    }

    void showStudentsInGroups() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                stringBuilder.append("Group ID ")
                        .append(entry.getKey());
                entry.getValue().printStudentList();
            }
            log.info(stringBuilder.toString());
        }
    }

    void showGroupsList() {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                stringBuilder.append("ID: ")
                        .append(entry.getKey())
                        .append(" Discipline: ")
                        .append(entry.getValue().getDiscipline().name())
                        .append('\n');
            }
            log.info("\nGroups list:\n{}\n", stringBuilder.toString());
        }
    }

    void showDisciplinesStudentAttended(Student student) {
        if (!groups.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Group> entry : groups.entrySet()) {
                if(entry.getValue().isStudentIn(student)) {
                    stringBuilder.append(student)
                            .append("in group ID")
                            .append(entry.getKey());
                }
            }
            log.info(stringBuilder.toString());
        }
    }
}
