package Blarb.ProgettoIngegneria.Entita.Factory;

import Blarb.ProgettoIngegneria.Entita.Product.Evento;

import java.time.Instant;
import java.util.Date;

public class Animatore extends Utente{

    public Animatore(String Nome, String Cognome, String Email, int Eta, Ruolo ruolo){
        super(Nome, Cognome, Email, Eta, ruolo);
    }

    public String CreatePost(String Descrizione, Date DataEvento, String LuogoEvento){
        Date Now = new Date();
        Evento Temp = new Evento(Now, Descrizione, DataEvento, LuogoEvento);
        return "Fatto";
    }
}
