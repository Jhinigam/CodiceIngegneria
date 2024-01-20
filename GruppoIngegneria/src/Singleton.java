import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Singleton utilizzato per comunicare direttamente con il database */
public class Singleton {
    private final String DB_URL;
    private final String USER;
    private final String PASS;
    Statement stmt;


    public Singleton() throws ClassNotFoundException {

        DB_URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11677848";
        USER = "sql11677848";
        PASS = "BQ9aLwIJDb";

        Class.forName("com.mysql.jdbc.Driver");     //Inizializzazione Driver JBDC

        try                                                   //Provo a instanziare una connessione al DB remoto
        {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getComuni() throws SQLException {           //Esegue una query che cerca tutti i comuni nel database
        
        ResultSet RS = null;
        try{
            String SELECTQUERY = "SELECT nome FROM comune";
            RS = stmt.executeQuery(SELECTQUERY);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        while(RS.next()){
            list.add(RS.getString("nome"));
        }
        return list;
    }

}
