package com.cleaningegneria.Application.Service;

import java.awt.*;
import java.util.Date;

public class PostBase extends Post{

    private Image Immagine; //non sappaiamo momentaneamente se tenere le immagini come immage o string di collegamento ad esse
    private Boolean Pending;

    /**
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     * @param Immagine Immagine del post, opsionale
     * @param Pending se il pending è ture il post è live
     *                se è false è in coda per approvazione
     */
    public PostBase (Date DataPubblicazione, String Descrizione, Image Immagine, Boolean Pending){
        super(DataPubblicazione, Descrizione);
        this.Immagine = Immagine;
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
        this.Immagine = null;
        this.Pending = Pending;
    }

    /**
     * il pending è false ed è quindi in coda per approvazione
     * @param DataPubblicazione Data di pubblicazione
     * @param Descrizione Descrizione
     * @param Immagine Immagine del post, opsionale
     */
    public PostBase (Date DataPubblicazione, String Descrizione, Image Immagine){
        super(DataPubblicazione, Descrizione);
        this.Immagine = Immagine;
        this.Pending = false;
    }

}
