public class Contributore_Autorizzato extends Contributore{
    public Contributore_Autorizzato(String Nome, String Cognome, int Eta, String Email, String Password, int ID){
        super(Nome, Cognome, Eta, Email, Password, ID);
    }

    @Override
    public void Pubblica(Itinerario itinerario) {
        itinerario.setPending(true);
        super.Pubblica(itinerario);
    }

    @Override
    public void Pubblica(PostBase postBase) {
        postBase.setPending(true);
        super.Pubblica(postBase);
    }
}
