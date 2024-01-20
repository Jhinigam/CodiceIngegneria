package Classi;

import java.sql.Timestamp;
import java.util.Date;

public class Post {
    private Timestamp DataPublicazione;
    private Utente Proprietario;
    private String Comune;
    private String Descrizione;



    public Post(Timestamp DataPublicazione, Utente Proprietario, String Comune, String Descrizione){
        this.DataPublicazione = DataPublicazione;
        this.Proprietario = Proprietario;
        this.Comune = Comune;
        this.Descrizione = Descrizione;
    }

    public Timestamp getDataPublicazione() {
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
