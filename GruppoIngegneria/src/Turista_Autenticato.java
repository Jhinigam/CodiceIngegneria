import java.util.ArrayList;
import java.util.List;

public class Turista_Autenticato extends Utente{
    private List<Integer> idPostSalvati;

    public Turista_Autenticato(String Nome, String Cognome, int Eta, String Email, String Password, int ID){
        super(Nome, Cognome, Eta, Email, Password);
        idPostSalvati = new ArrayList<>();
    }

    public void SalvaPost(Post post){

    }
}
