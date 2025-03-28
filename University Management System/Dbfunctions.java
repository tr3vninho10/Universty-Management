import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbfunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");


            String url = "jdbc:postgresql://localhost:5432/" + dbname;
            conn = DriverManager.getConnection(url, user, pass);

            if (conn != null) {
                System.out.println("Connected to PostgreSQL database: " + dbname);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found!");
            e.printStackTrace(System.out);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}