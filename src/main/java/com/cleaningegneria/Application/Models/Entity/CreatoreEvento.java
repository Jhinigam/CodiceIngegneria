package com.cleaningegneria.Application.Models.Entity;

import java.sql.Timestamp;

public class CreatoreEvento extends Utente{

    Timestamp DataEvento;
    public CreatoreEvento(Timestamp DataEvento){
        this.DataEvento = DataEvento;
    }
    public PostBase CreaPost(int IdUtente, String Desc){
        Evento Temp = new Evento(DataEvento,IdUtente,Desc);
        return Temp;
    }

}