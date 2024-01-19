public class Contributore extends Utente{
    private String Comune;

    public Contributore(String Nome, String Cognome, int Eta, String Email, String Password, int ID){
        super(Nome, Cognome, Eta, Email, Password, ID);
        this.Comune = Comune;
    }

    public void Pubblica(Itinerario itinerario){
        itinerario.setPending(true);

    }

    public String Pubblica(PostBase postBase){
        postBase.setPending(true);
        String Query = "INSERT INTO post (dataPost, idcomune, idutente, descrizione_null, immagine_null, pending) " +
                        "VALUES ( "  + postBase.getDataPublicazione() + ", " +
                        postBase.getComune() + ", " +
                        postBase.getProprietario() + ", " +
                        postBase.getDescrizione() + ", " +
                        postBase.getImmagine() + ", " +
                        postBase.getPending() +
                ")" ;
        return Query;
    }

}
