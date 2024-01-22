package Classi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Singleton utilizzato per comunicare direttamente con il database */
public class Singleton implements Database_Interface{
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
            String query = "SELECT nome FROM comune";
            RS = stmt.executeQuery(query);
            
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


    @Override
    public void aggiungi(Utente utente) {
        ResultSet RS = null;
        try {
            String query = "INSERT INTO utente (nome, cognome, eta, email, password, idcomune, ruolo) " +
                    "VALUES ('" + utente.getNome() + "', '" + utente.getCognome() + "', " + utente.getEta() +
                    ", '" + utente.getEmail() + "', '" + utente.getPassword() + "', " + getComuneID(utente.getComune()) +
                    ", '" + utente.getRuolo() + "')";

            RS = stmt.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void aggiungi(PostBase postBase) {
        ResultSet RS = null;
        try {
            String query = "INSERT INTO post (dataPost, idcomune, idutente, descrizione, immagine, pending) " +
                    "VALUES ('" + postBase.getDataPublicazione() + "', " + getComuneID(postBase.getComune()) + ", " +
                    getUtenteID(postBase.getProprietario().getNome(), postBase.getProprietario().getCognome(), postBase.getProprietario().getEta()) + ", '" +
                    postBase.getDescrizione() + "', '" + postBase.getImmagine() + "', '" + postBase.getPending() + "')";

            RS = stmt.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void aggiungi(Evento evento) {

    }

    @Override
    public void aggiungi(Itinerario itinerario) {

    }

    @Override
    public void aggiungi(String comune) {
        ResultSet RS = null;
        try {
            String query = "INSERT INTO comune (nome) VALUES ('" + comune + "')";
            RS = stmt.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getUtenteID(String nome, String cognome, int eta) {
        ResultSet RS = null;
        int ID = -1;
        try {
            String query = "SELECT id FROM utente WHERE nome='" + nome + "' AND cognome='" + cognome + "' AND eta=" + eta;
            RS = stmt.executeQuery(query);
            if (RS.next()){
                ID = RS.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public void accettaPending(PostBase postBase) {

    }

    @Override
    public void promuoviUtente(Utente utente) {

    }

    @Override
    public ArrayList<PostBase> getPostInseriti(Utente utente) {
        return null;
    }

    @Override
    public int getComuneID(String comune) {
        ResultSet RS = null;
        int ID = -1;
        try {
            String query = "SELECT id FROM comune WHERE nome = '" + comune + "'";
            RS = stmt.executeQuery(query);
            if (RS.next()){
                ID = RS.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public boolean cercaComune(String comune) {
        ResultSet RS = null;
        boolean comuneEsistente = false;
        try {
            String query = "SELECT COUNT(*) as count FROM comune WHERE nome = '" + comune + "'";
            RS = stmt.executeQuery(query);
            if (RS.next()){
                int count = RS.getInt("count");
                comuneEsistente = (count > 0);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return comuneEsistente;
    }
}
