package com.cleaningegneria.Application.Models;

import java.util.Date;

public class Evento extends Post{

    private Date DataEvento;
    private String LuogoEvento;

    /**
     * @param DataPubblicazione Data pubblicazione post
     * @param Descrizione Descrizione evento
     * @param DataEvento Data evento
     * @param LuogoEvento Luogo evento
     */
    public Evento(Date DataPubblicazione, String Descrizione, Date DataEvento, String LuogoEvento){
        super(DataPubblicazione, Descrizione);
        this.DataEvento = DataEvento;
        this.LuogoEvento = LuogoEvento;
    }

}
