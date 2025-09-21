import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {

    private int id;
    private int patientId;
    private int doctorId;
    private String date;

    public Appointment(int id, int patientId, int doctorId, String date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    // getters
    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }

    // static method to schedule an appointment
    public static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        try (Connection conn = Database.connect()) {
            String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setString(3, date);
            stmt.executeUpdate();
            System.out.println(" Appointment scheduled successfully!");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
