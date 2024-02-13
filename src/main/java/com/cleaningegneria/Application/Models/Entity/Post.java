package com.cleaningegneria.Application.Models.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private Date DataPubblicazione;
    private String Descrizione;
    @ManyToOne
    Utente creatore = null;


    /**
     * @param DataPubblicazione Data di pubblicazione post
     * @param Descrizione Descrizione del post
     */
    public Post (Date DataPubblicazione, String Descrizione){
        this.DataPubblicazione = DataPubblicazione;
        this.Descrizione = Descrizione;
    }



}
