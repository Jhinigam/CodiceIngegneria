import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args){

        ArrayList<Post> ListaPostBase = new ArrayList<>();
        Utente a = new Utente();
        Date date = new Date();
        Itinerario i = new Itinerario(date, a, "Ancona","Ciao Ragazzi", ListaPostBase);
        System.out.println(i.getComune());
    }
}