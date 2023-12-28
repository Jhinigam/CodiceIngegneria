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
}
