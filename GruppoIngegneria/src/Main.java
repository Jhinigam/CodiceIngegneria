import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        final String DB_URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11677848";
        final String USER = "sql11677848";
        final String PASS = "BQ9aLwIJDb";
        String SELECTQUERY = "SELECT * FROM comune";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SELECTQUERY);
            while(rs.next()){
                //Display values
                System.out.print("\nID: " + rs.getInt("id"));
                System.out.print(",\nNome: " + rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}