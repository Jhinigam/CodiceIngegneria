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
    const url = `${BASE_URL}Utente/Creazione`;

    // Assicurati che i nomi dei campi qui corrispondano esattamente a quelli della tua classe DTO in Java
    const data = {
        nome: nome, // anziché Nome
        cognome: cognome, // anziché Cognome
        email: email, // anziché Email
        comune: comune, // anziché Comune
        ruolo: ruolo, // ruolo è corretto se la tua classe DTO ha il campo con la lettera minuscola
        eta: eta // anziché Eta
    };

    return fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status !== 200) {
            throw new Error('Errore nella richiesta: ' + response.statusText);
        }
        return response.text();
    });
}
function ConnectionDati(){
    return fetch(`${BASE_URL}Utente/DatiUtente`)
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
//fune esempio
function ConnectionModificaRuolo(Id, Ruolo){
    const url = `${BASE_URL}Utente/MRuolo`;

    const data= {
        id: Id,
        newRuolo: Ruolo
    };

    return fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.text(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionAddPostBase(Id, Descrizione){
const url = `${BASE_URL}Post/CreazionePostBase`;

    const data= {
        idUtente: Id,
        descrizione: Descrizione
    };

    return fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.text(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionAddItinerario(Id, Descrizione){
const url = `${BASE_URL}Post/CreazioneItinerario`;

    const data= {
        idUtente: Id,
        descrizione: Descrizione
    };

    return fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.text(); // Questo ritorna una Promise che si risolve con i dati JSON
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
        console.log("Utente aggiunto correttamente");
   }else{ console.log("Utente non aggiunto"); }

}
function Dati(){
    ConnectionDati().then(dati => {
    console.log(dati);
        // Assicurati che gli ID corrispondano agli elementi nel tuo HTML
        document.getElementById('NomeL').textContent = String(dati.nome); // Assumi che l'oggetto Utente abbia una proprietà 'nome'
        document.getElementById('CognomeL').textContent = String(dati.ruolo); // Assumi che l'oggetto Utente abbia una proprietà 'cognome'
    }).catch(error => {
        console.log(dati);
        console.error(error);
    });
}
function CambioRuolo(){
    var tempId = String(document.getElementById('idMR').value);
    var tempRuolo = String(document.getElementById('RuoloMR').value);

     if(ConnectionModificaRuolo(tempId, tempRuolo) != null){
            console.log("Utente modificato correttamente");}else{console.log("Utente non modificato")}
}
function PostBase(){
    var tempId = document.getElementById('IdUtentePost').value;
    var tempDesc = String(document.getElementById('DescrizionePost').value);

    ConnectionAddPostBase(tempId, tempDesc);
}
function Itinerario(){
    var tempId = document.getElementById('IdUtenteItinerario').value;
    var tempDesc = String(document.getElementById('DescrizioneItinerario').value);

    ConnectionAddItinerario(tempId, tempDesc);
}
