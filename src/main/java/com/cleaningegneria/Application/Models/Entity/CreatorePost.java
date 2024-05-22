package com.cleaningegneria.Application.Models.Entity;

public class CreatorePost extends Utente{
    boolean Pending;
    public CreatorePost(boolean Pending){
        this.Pending = Pending;
    }
    public PostBase CreaPost(int IdUtente, String Desc){
        Post Temp = new Post(IdUtente, Desc, Pending);
        return Temp;
    }

}
