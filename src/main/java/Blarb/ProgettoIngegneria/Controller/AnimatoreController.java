package Blarb.ProgettoIngegneria.Controller;

import Blarb.ProgettoIngegneria.Entita.Factory.Animatore;
import Blarb.ProgettoIngegneria.Entita.Factory.Ruolo;
import Blarb.ProgettoIngegneria.Entita.Product.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/Animatore")
public class AnimatoreController extends AbstractController{

    private Animatore Io;

    /**
     * @param Nome Nome
     * @param Cognome Cognome
     * @param Email Email
     * @param Eta Età
     */
    public AnimatoreController (String Nome, String Cognome, String Email, int Eta){
        Io = new Animatore(Nome, Cognome, Email, Eta, Ruolo.Animatore);
    }

    @GetMapping("/CreateItinerario")
    public String CreatePost(String Descrizione, Date data, String luogo){
        return Io.CreatePost(Descrizione, data, luogo);
    }

}
