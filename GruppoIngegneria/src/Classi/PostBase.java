package Classi;

import Classi.Post;

import java.awt.*;
import java.sql.Timestamp;

public class PostBase extends Post {
    private Image Immagine;
    private boolean Pending;

    public PostBase(Timestamp DataPublicazione, Utente Proprietario, String Comune, String Descrizione, Image Immagine) {
        super(DataPublicazione, Proprietario, Comune, Descrizione);
        this.Immagine = Immagine;

    }

    public void setPending(boolean Pending) {
        this.Pending = Pending;
    }

    public Image getImmagine() {
        return Immagine;
    }

    public boolean getPending(){
        return Pending;
    }
}
