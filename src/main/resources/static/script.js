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
    // Costruzione corretta dell'URL con i valori delle variabili
    const url = `${BASE_URL}Utente/Creazione?Nome=${encodeURIComponent(nome)}&Cognome=${encodeURIComponent(cognome)}&Email=${encodeURIComponent(email)}&Comune=${encodeURIComponent(comune)}&ruolo=${encodeURIComponent(ruolo)}&Eta=${encodeURIComponent(eta)}`;

    return fetch(url, {
        method: 'PUT', // Assicurati che questo metodo sia supportato dal backend
        headers: {
            'Content-Type': 'application/json',
        },
        // Invio di un oggetto JSON nel corpo della richiesta, se necessario
        body: JSON.stringify({
            Nome: nome,
            Cognome: cognome,
            Email: email,
            Comune: comune,
            ruolo: ruolo,
            Eta: eta
        })
    })
    .then(response => {
        if (response.status !== 200) {
            throw new Error('Errore nella richiesta: ' + response.statusText);
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