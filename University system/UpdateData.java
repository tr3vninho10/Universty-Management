import java.sql.Connection;
import java.sql.Statement;

public class UpdateData {

    private String formatValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }

    public void updateData(Connection conn, String table_name, String column_to_update, Object new_value, String condition_column, Object condition_value) {
        Statement statement;
        try {
            String query = String.format("UPDATE %s SET %s=%s WHERE %s=%s;",
                    table_name, column_to_update, formatValue(new_value), condition_column, formatValue(condition_value));
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated in " + table_name);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


