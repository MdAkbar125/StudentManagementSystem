import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        students.add(new Student(id, name, age, course, marks));

        System.out.println("Student added successfully!");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        student.setName(sc.nextLine());

        System.out.print("Enter New Age: ");
        student.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter New Course: ");
        student.setCourse(sc.nextLine());

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks.");
            return;
        }

        student.setMarks(marks);

        System.out.println("Student updated successfully!");
    }

    public void deleteStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void sortStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("Students sorted by marks:");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    private Student findStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}