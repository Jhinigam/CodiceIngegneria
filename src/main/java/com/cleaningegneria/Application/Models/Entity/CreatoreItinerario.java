package com.cleaningegneria.Application.Models.Entity;

public class CreatoreItinerario extends Utente{
    public CreatoreItinerario(){
        //bo
    }
    public PostBase CreaPost(int IdUtente, String Desc){
        Itinerario Temp = new Itinerario(IdUtente, Desc);
        return Temp;
    }

}