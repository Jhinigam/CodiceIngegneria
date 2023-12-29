import java.util.Date;

public class Post {
    private Date DataPublicazione;
    private Utente Proprietario;
    private String Comune;
    private String Descrizione;



    public Post(Date DataPublicazione, Utente Proprietario, String Comune, String Descrizione){
        this.DataPublicazione = DataPublicazione;
        this.Proprietario = Proprietario;
        this.Comune = Comune;
        this.Descrizione = Descrizione;
    }

    public Date getDataPublicazione() {
        return DataPublicazione;
    }

    public Utente getProprietario() {
        return Proprietario;
    }

    public String getComune() {
        return Comune;
    }

    public String getDescrizione() {
        return Descrizione;
    }
}
