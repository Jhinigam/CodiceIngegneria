package Classi;

import Classi.Contributore;

import java.sql.SQLException;

public class Contributore_Autorizzato extends Contributore {
    public Contributore_Autorizzato(String Nome, String Cognome, int Eta, String Email, String Password) throws Exception {
        super(Nome, Cognome, Eta, Email, Password);
    }

    @Override
    public void Pubblica(Itinerario itinerario) {
        itinerario.setPending(false);
        super.Pubblica(itinerario);
    }

    @Override
    public void Pubblica(PostBase postBase) {
        postBase.setPending(false);
        super.Pubblica(postBase);
    }
}
