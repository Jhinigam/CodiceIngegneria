package Blarb.ProgettoIngegneria.Model;

import Blarb.ProgettoIngegneria.Service.Factory.Ruolo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UtenteModel {
    @Id
    private Integer id;
    private String Nome;
    private String Cognome;
    private String Email;
    private List<Integer> PostSalvati;
    private int Eta;
    private Ruolo ruolo;

    /**
     * Costruttore Utente
     * @param Nome String
     * @param Cognome String
     * @param Email String
     * @param Eta Int
     * @param ruolo se il ruolo è 0 o 1, l'utente non è autorizzato
     */
    public UtenteModel(String Nome, String Cognome, String Email, int Eta, Ruolo ruolo){
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Email = Email;
        this.Eta = Eta;
        this.ruolo = ruolo;
    }


}