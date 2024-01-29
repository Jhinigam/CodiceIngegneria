package com.cleaningegneria.Application.Service;

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
        //introdurre il set dell' Id preso dal Database
        return Id;
    }

}
