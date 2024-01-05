public abstract class Contributore extends Utente{
    private String Comune;

    public Contributore(String Nome, String Cognome, int Eta, String Email, String Password, int ID){
        super(Nome, Cognome, Eta, Email, Password, ID);
        this.Comune = Comune;
    }

    public void Pubblica(Itinerario itinerario){
        itinerario.setPending(false);
    }

    public void Pubblica(PostBase postBase){
        postBase.setPending(true);

    }

}
