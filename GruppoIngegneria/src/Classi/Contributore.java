package Classi;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contributore extends Utente {
    private String Comune;

    public Contributore(String Nome, String Cognome, int Eta, String Email, String Password) throws Exception {
        super(Nome, Cognome, Eta, Email, Password);
        this.Comune = Comune;
    }

    public void Pubblica(Itinerario itinerario){
        itinerario.setPending(true);

    }

    public void Pubblica(PostBase postBase) {
        postBase.setPending(true);
    }

}
