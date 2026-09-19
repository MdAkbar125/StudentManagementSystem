import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.addStudent(sc);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    manager.searchStudent(sc);
                    break;

                case 4:
                    manager.updateStudent(sc);
                    break;

                case 5:
                    manager.deleteStudent(sc);
                    break;

                case 6:
                    manager.sortStudents();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}