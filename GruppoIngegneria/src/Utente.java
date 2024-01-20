import java.security.PublicKey;

public abstract class Utente {
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
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public int getEta() {
        return Eta;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}

