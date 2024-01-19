import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

public class Evento extends Post{
    private Date DataEvento;
    private String LuogoEvento;

    public Evento(Timestamp DataPublicazione, Utente Proprietario, String Comune, String Descrizione, Date DataEvento, String LuogoEvento) {
        super(DataPublicazione, Proprietario, Comune, Descrizione);
        this.DataEvento = DataEvento;
        this.LuogoEvento = LuogoEvento;
    }
}
