const BASE_URL = 'http://localhost:8080/';
const SHOWCASE_MODE = true;

//Test Connection
function TestConnection(){
    return fetch(`${BASE_URL}Test`)
         .then(response => {
         if (response.status !== 200) {
            throw new Error(JSON.stringify(response.json()));
         }
         return response.text();
        });
}
function TestSing(){
     var label = document.getElementById('Test');

        TestConnection().then(result => {
            label.textContent = result;
            label.style.color = '#14d928';
        }).catch(error => {
            console.error('Errore nella fetch:', error);
            label.textContent = 'Disconnected';
            label.style.color = '#FF0000';
        });
}



//Connection List
function ConnectAddUtente(nome, cognome, email, comune, ruolo, eta){
    var nome2 = nome;
    return fetch(`${BASE_URL}Utente/Creazione?
        Nome=${name}
        &Cognome=${cognome}
        &Email=${email}
        &Comune=${comune}
        &ruolo=${ruolo}
        &Eta=${eta}`,{

        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(nome),
        })
         .then(response => {
         if (response.status !== 200) {
            throw new Error(JSON.stringify(response.json()));
         }
         return response.text();
        });
}

//Funzioni
function AddUtente(){
   var ValNome = document.getElementById('Nome').value;
   var ValCognome = document.getElementById('Cognome').value;
   var ValEmail = document.getElementById('Email').value;
   var ValComuni = document.getElementById('Comuni').value;
   var ValRuolo = document.getElementById('Ruolo').value;
   var ValEta = document.getElementById('eta').value;

   if(ConnectAddUtente(String(ValNome),
                       String(ValCognome),
                       String(ValEmail),
                       String(ValComuni),
                       String(ValRuolo),
                       String(ValEta)) != null){
        return "ok";
   }

   return "non Ok";
}