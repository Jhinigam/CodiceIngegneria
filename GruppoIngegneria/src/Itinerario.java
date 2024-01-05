import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Itinerario extends Post{
    private ArrayList<Post> ListaPostBase;
    private boolean Pending;
    
    public Itinerario(Date DataPublicazione, Utente Proprietario, String Comune, String Descrizione, ArrayList<Post> ListaPostBase){
        super(DataPublicazione, Proprietario, Comune, Descrizione);
        this.ListaPostBase = new ArrayList<Post>();
        this.Pending = true;
        for (Post p: ListaPostBase) {
            this.ListaPostBase.add(p);
        }
    }

    public void setPending(boolean Pending) {
        this.Pending = Pending;
    }
}
