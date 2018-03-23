package subtasks.five;

public class Main {
    public static void main(String... args) {
        GradeBook gradeBook = new GradeBook();

        Student student1 = new Student(1,"firstName1", "lastName1");
        Student student2 = new Student(2,"firstName2", "lastName2");
        Student student3 = new Student(3,"firstName3", "lastName3");
        Student student4 = new Student(4,"firstName4", "lastName4");
        Student student5 = new Student(5,"firstName5", "lastName5");

        gradeBook.addGroup(1,Discipline.PHYSICS);
        gradeBook.addGroup(1,Discipline.MATHEMATICS);
        gradeBook.addGroup(1,Discipline.BIOLOGY);
        gradeBook.addGroup(2,Discipline.BIOLOGY);
        gradeBook.addGroup(3,Discipline.ENGLISH);
        gradeBook.addGroup(4,Discipline.MATHEMATICS);
        gradeBook.addGroup(5,Discipline.MATHEMATICS);

        gradeBook.addStudent(student1, 1);
        gradeBook.addStudent(student1, 2);
        gradeBook.addStudent(student1, 3);
        gradeBook.addStudent(student1, 4);
        gradeBook.addStudent(student1, 5);
        gradeBook.addStudent(student1, 6);
        gradeBook.addStudent(student2,2 );
        gradeBook.addStudent(student2,3);
        gradeBook.addStudent(student2, 3);
        gradeBook.addStudent(student2,5);
        gradeBook.addStudent(student3, 3);
        gradeBook.addStudent(student3, 4);
        gradeBook.addStudent(student3, 5);
        gradeBook.addStudent(student4, 4);
        gradeBook.addStudent(student4, 5);
        gradeBook.addStudent(student5, 5);

        gradeBook.addGrade(student1, 2, 5);
        gradeBook.addGrade(student1, 3, 5);
        gradeBook.addGrade(student5, 3, 4);

        gradeBook.showGroupsList();

        gradeBook.showStudentsInGroups();

        gradeBook.showDisciplinesStudentAttended(student1);
        gradeBook.showDisciplinesStudentAttended(student2);
        gradeBook.showDisciplinesStudentAttended(student3);
        gradeBook.showDisciplinesStudentAttended(student4);
        gradeBook.showDisciplinesStudentAttended(student5);

        gradeBook.showStudentsGrades(student1);
        gradeBook.showStudentsGrades(student2);
        gradeBook.showStudentsGrades(student3);
        gradeBook.showStudentsGrades(student4);
        gradeBook.showStudentsGrades(student5);
    }
}
