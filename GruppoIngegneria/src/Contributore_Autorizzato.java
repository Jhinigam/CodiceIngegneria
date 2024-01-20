public class Contributore_Autorizzato extends Contributore{
    public Contributore_Autorizzato(String Nome, String Cognome, int Eta, String Email, String Password, int ID){
        super(Nome, Cognome, Eta, Email, Password, ID);
    }

    @Override
    public void Pubblica(Itinerario itinerario) {
        itinerario.setPending(false);
        super.Pubblica(itinerario);
    }

    @Override
    public void Pubblica(PostBase postBase) {
        postBase.setPending(false);
        super.Pubblica(postBase);
    }
}
