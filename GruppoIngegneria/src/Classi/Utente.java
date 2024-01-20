package Classi;

public class Utente {
    private String Nome;
    private String Cognome;
    private int Eta;
    private String Email;
    private String Password;
    private int ID;

    public Utente(String Nome, String Cognome, int Eta, String Email, String Password){
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Eta = Eta;
        this.Password = Password;

    }

    public void setId(int ID){
        this.ID = ID;
    }
}
