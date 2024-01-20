package Classi;

import Classi.Contributore_Autorizzato;

public class Curatore extends Contributore_Autorizzato {

    public Curatore(String Nome, String Cognome, int Eta, String Email, String Password){
        super(Nome, Cognome, Eta, Email, Password);
    }

    public void AccettaPending(Itinerario itinerario){
        itinerario.setPending(true);
    }

    public void AccettaPending(PostBase postBase){
        postBase.setPending(true);
    }

    public void RifiutaPending(Itinerario itinerario){
        itinerario.setPending(true);
    }

    public void RifiutaPending(PostBase postBase){
        postBase.setPending(true);
    }

    public void PromuoviUtente(Utente utente){

    }

    public void DeclassaUtente(Utente utente){

    }

}
