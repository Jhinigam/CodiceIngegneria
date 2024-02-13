package com.cleaningegneria.Application.Models.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class PostBase extends Post{

private Boolean Pending;

    /**
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     * @param Pending se il pending è ture il post è live
     *                se è false è in coda per approvazione
     */
    public PostBase (Date DataPubblicazione, String Descrizione, Image Immagine, Boolean Pending){
        super(DataPubblicazione, Descrizione);
        this.Pending = Pending;
    }

    /**
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     * @param Pending se il pending è ture il post è live
     *                se è false è in coda per approvazione
     */
    public PostBase (Date DataPubblicazione, String Descrizione, Boolean Pending){
        super(DataPubblicazione, Descrizione);
        this.Pending = Pending;
    }

    /**
     * il pending è false ed è quindi in coda per approvazione
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     */
    public PostBase (Date DataPubblicazione, String Descrizione, Image Immagine){
        super(DataPubblicazione, Descrizione);
        this.Pending = false;
    }

}
