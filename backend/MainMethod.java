

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hospital Management System ===");

        try {
            Connection conn = Database.connect();
            if (conn != null) {
                System.out.println(" Connected to Database!");
            }

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Register Patient");
                System.out.println("2. Register Doctor");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        Patient.registerPatient(scanner);
                        break;
                    case 2:
                        Doctor.registerDoctor(scanner);
                        break;
                    case 3:
                        Appointment.scheduleAppointment(scanner);
                        break;
                    case 4:
                        System.out.println(" Exiting system...");
                        conn.close();
                        return;
                    default:
                        System.out.println(" Invalid choice!");
                }
            }
        } catch (SQLException e) {
            System.out.println(" Database error: " + e.getMessage());
        }
    }
}
