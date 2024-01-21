package Classi;

import java.sql.SQLException;

public class Utente {
    private String Nome;
    private String Cognome;
    private int Eta;
    private String Email;
    private String Password;
    private int ID;

    public Utente(String Nome, String Cognome, int Eta, String Email, String Password) throws Exception {
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Eta = Eta;
        this.Password = Password;
        setId();
    }

    public void setId() throws Exception {
        Singleton s = new Singleton();
        if (s.getIdUser(this.Nome,this.Cognome,this.Eta) == -1){
            throw new Exception("L'utente " + this.Nome + " " + this.Cognome + "di età " + this.Eta + "non esiste");
        }
        else {
            this.ID = s.getIdUser(this.Nome,this.Cognome,this.Eta);
        }

    }
}
