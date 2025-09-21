import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn;

    public static Connection connect() {
        if (conn == null) {
            try {
                // Explicitly load the driver
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital?useSSL=false&serverTimezone=UTC",
                    "root",
                    "your_password_here"
                );
                System.out.println("DB Connected");
            } catch (ClassNotFoundException e) {
                System.out.println("❌ MySQL Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ SQL Error: " + e.getMessage());
            }
        }
        return conn;
    }
}
