package Classi;

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

    /**
     * @return lista di nomi dei comuni
     * @throws SQLException
     */
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

    public int getIdUser(String nome, String cognome, int eta) throws SQLException {
        ResultSet RS = null;
        int ID = -1;
        try {
            String SELECTQUERY = "SELECT id FROM utente WHERE nome='" + nome + "' AND cognome='" + cognome + "' AND eta=" + eta;
            RS = stmt.executeQuery(SELECTQUERY);
            if (RS.next()){
                ID = RS.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ID;
    }

    public void addUser(Utente utente){
        ResultSet RS = null;
    }


    

}
