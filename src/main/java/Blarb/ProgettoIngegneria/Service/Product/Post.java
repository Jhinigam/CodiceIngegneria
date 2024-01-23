package Blarb.ProgettoIngegneria.Service.Product;

import java.util.Date;

public abstract class Post{
    private Date DataPubblicazione;
    private int Id;
    private String Descrizione;

    /**
     * @param DataPubblicazione Data di pubblicazione post
     * @param Descrizione Descrizione del post
     */
    public Post (Date DataPubblicazione, String Descrizione){
        this.DataPubblicazione = DataPubblicazione;
        this.Descrizione = Descrizione;
    }

    public int getId(){
        //introdure il set del Id preso dal Database
        return Id;
    }

}
