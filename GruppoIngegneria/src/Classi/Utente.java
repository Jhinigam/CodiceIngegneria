package Classi;

import java.sql.SQLException;

public class Utente {
    private String Nome;
    private String Cognome;
    private int Eta;
    private String Email;
    private String Password;
    private int ID;
    private String Comune;
    private int Ruolo;

    public Utente(String Nome, String Cognome, int Eta, String Email, String Password, String Comune) throws Exception {
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Eta = Eta;
        this.Password = Password;
        this.Comune = Comune;
        Ruolo = 1;
        setId();
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public int getEta() {
        return Eta;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getComune() {
        return Comune;
    }

    public int getRuolo(){
        return Ruolo;
    }

    public int getID() {
        return ID;
    }

    public void setId() throws Exception {
        Singleton s = new Singleton();
        if (s.getUtenteID(this.Nome,this.Cognome,this.Eta) == -1){
            throw new Exception("L'utente " + this.Nome + " " + this.Cognome + "di età " + this.Eta + "non esiste");
        }
        else {
            this.ID = s.getUtenteID(this.Nome,this.Cognome,this.Eta);
        }

    }
}
