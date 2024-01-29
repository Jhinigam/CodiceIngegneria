package Blarb.ProgettoIngegneria.Entita.Product;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Itinerario extends Post {
    private List<Integer> ListaPost;

    /**
     * crazione di un itinerario contenente nessun post
     * @param DataPubblicazione Data di Pubblicazione
     * @param Descrizione Descrizione
     */
    public Itinerario (Date DataPubblicazione, String Descrizione){
        super(DataPubblicazione, Descrizione);
    }

    /**
     *
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     * @param P Primo post da aggiungere alla lista
     */
    public Itinerario (Date DataPubblicazione, String Descrizione, PostBase P){
        super(DataPubblicazione, Descrizione);
        AddPost(P);
    }

    /**
     * @param P l'Id del post viene aggiunto alla lista dei post relativi al itinerario
     */
    public void AddPost (PostBase P){
        ListaPost.add(P.getId());
    }

}
