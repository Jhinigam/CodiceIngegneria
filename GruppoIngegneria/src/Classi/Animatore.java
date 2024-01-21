package Classi;

import java.sql.SQLException;

public class Animatore extends Contributore_Autorizzato {

    public Animatore(String Nome, String Cognome, int Eta, String Email, String Password) throws Exception {
        super(Nome, Cognome, Eta, Email, Password);
    }

    public void Pubblica(Evento evento){


    }
}
