import java.awt.*;
import java.util.Date;

public class PostBase extends Post {
    private Image Immagine;
    private boolean Pending;

    public PostBase(Date DataPublicazione, Utente Proprietario, String Comune, String Descrizione, Image Immagine) {
        super(DataPublicazione, Proprietario, Comune, Descrizione);
        this.Immagine = Immagine;

    }

    public void setPending(boolean Pending) {
        this.Pending = Pending;
    }


}
