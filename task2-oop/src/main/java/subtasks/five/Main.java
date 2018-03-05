package subtasks.five;

public class Main {
    public static void main(String... args) {
        GradeBook gradeBook = new GradeBook();
        Student student1 = new Student("firstName1", "lastName1");
        Student student2 = new Student("firstName2", "lastName2");
        Student student3 = new Student("firstName3", "lastName3");
        Student student4 = new Student("firstName4", "lastName4");
        Student student5 = new Student("firstName5", "lastName5");

/*        gradeBook.addStudent(student1);
        gradeBook.addStudent(student2);
        gradeBook.addStudent(student3);
        gradeBook.addStudent(student4);
        gradeBook.addStudent(student5);
        gradeBook.addStudent(student5);
        gradeBook.addStudent(student5);*/

        gradeBook.showStudentsList();

        gradeBook.addNewGroup(Disciplines.PHYSICS);
        gradeBook.addNewGroup(Disciplines.BIOLOGY);
        gradeBook.addNewGroup(Disciplines.ENGLISH);
        gradeBook.addNewGroup(Disciplines.MATHEMATICS);

        gradeBook.showDisciplinesList();

        gradeBook.addStudent(student1, Disciplines.BIOLOGY);
        gradeBook.addStudent(student1, Disciplines.PHYSICS);
        gradeBook.addStudent(student2, Disciplines.BIOLOGY);
        gradeBook.addStudent(student3, Disciplines.PHYSICS);
        gradeBook.addStudent(student4, Disciplines.PHYSICS);
        gradeBook.addStudent(student5, Disciplines.BIOLOGY);
        gradeBook.addStudent(student2, Disciplines.CHEMISTRY);

        gradeBook.showStudentsList();
        gradeBook.showDisciplinesStudentAttendend("firstName5", "lastName5");

        gradeBook.addGrade("firstName5", "lastName5", Disciplines.BIOLOGY, 5);
        gradeBook.showStudentsGrades("firstName5", "lastName5");
    }
}
