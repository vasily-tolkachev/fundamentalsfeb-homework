package subtasks.five;

public class Main {
    public static void main(String... args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.addStudent("firstName1", "lastName1");
        gradeBook.addStudent("firstName2", "lastName2");
        gradeBook.addStudent("firstName3", "lastName3");
        gradeBook.addStudent("firstName4", "lastName4");
        gradeBook.addStudent("firstName5", "lastName5");

        gradeBook.showStudentsList();

        gradeBook.addNewGroup(Disciplines.PHYSICS);
        gradeBook.addNewGroup(Disciplines.BIOLOGY);
        gradeBook.addNewGroup(Disciplines.ENGLISH);
        gradeBook.addNewGroup(Disciplines.MATHEMATICS);

        gradeBook.showDisciplinesList();

        gradeBook.assignStudentToDiscipline("firstName1", "lastName1", Disciplines.BIOLOGY);
        gradeBook.assignStudentToDiscipline("firstName2", "lastName2", Disciplines.PHYSICS);
        gradeBook.assignStudentToDiscipline("firstName3", "lastName3", Disciplines.PHYSICS);
        gradeBook.assignStudentToDiscipline("firstName4", "lastName4", Disciplines.BIOLOGY);
        gradeBook.assignStudentToDiscipline("firstName5", "lastName5", Disciplines.PHYSICS);

        gradeBook.showStudentsList();
        gradeBook.showDisciplinesStudentAttendend("firstName5", "lastName5");

        gradeBook.addGrade("firstName5", "lastName5", Disciplines.BIOLOGY, 5);
        gradeBook.showStudentsGrades("firstName5", "lastName5");
    }
}
