import java.sql.Connection;
import java.sql.DriverManager;

public class Dbfunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {

        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("tutdb", "postgres", "zkj3jte1xke1");


    }

}
