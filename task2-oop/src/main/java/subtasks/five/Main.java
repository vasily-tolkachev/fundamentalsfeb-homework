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

        gradeBook.addDiscipline("Physics");
        gradeBook.addDiscipline("Mathematics");
        gradeBook.addDiscipline("Biology");
        gradeBook.addDiscipline("English");

        gradeBook.showDisciplinesList();

        gradeBook.assignStudentToDiscipline("firstName1", "lastName1", "Physics");
        gradeBook.assignStudentToDiscipline("firstName2", "lastName2", "Physics");
        gradeBook.assignStudentToDiscipline("firstName3", "lastName3", "Biology");
        gradeBook.assignStudentToDiscipline("firstName4", "lastName4", "Biology");
        gradeBook.assignStudentToDiscipline("firstName5", "lastName5", "Physics");

        gradeBook.showDisciplinesStudentAttendend("firstName5", "lastName5");

        gradeBook.addGrade("firstName5", "lastName5", "Biology", 5);
        gradeBook.showStudentsGrades("firstName5", "lastName5");
    }
}
