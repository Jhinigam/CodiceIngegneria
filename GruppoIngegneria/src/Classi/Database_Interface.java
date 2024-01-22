package Classi;

import java.util.ArrayList;

public interface Database_Interface {

    void aggiungi(Utente utente);

    void aggiungi(PostBase postBase);

    void aggiungi(Evento evento);

    void aggiungi(Itinerario itinerario);

    void aggiungi(String comune);

    int getUtenteID(String nome, String cognome, int eta);

    void accettaPending(PostBase postBase);

    void promuoviUtente(Utente utente);

    ArrayList<PostBase> getPostInseriti(Utente utente);

    int getComuneID(String comune);

    boolean cercaComune(String comune);

}
