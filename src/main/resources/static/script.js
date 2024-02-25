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
function ConnectionVisualizzaUtenteId(Id){
    return fetch(`${BASE_URL}Utente/VisualizzaUtente?idUtente=`+ String(Id))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
//fune esempio
function ConnectionModificaRuolo(Id, Ruolo){
    const url = `${BASE_URL}Utente/ModificaRuolo`;

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
            console.log("post aggiunto");
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
function ConnectionDeleteUtente(Id){
const url = `${BASE_URL}Utente/Cancella?idUtente=`+ String(Id);

return fetch(url, {
    method: 'GET',

}).then(response => {
    return response.text();
}).catch(error => {
    console.error('Errore durante la richiesta:', error);
});

}
function ConnectionVisualizzaPostId(Id){
    return fetch(`${BASE_URL}Post/VisualizzaPost?idPost=`+ String(Id))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionAddEvento(Id, Descrizione, DataEvento){
const url = `${BASE_URL}Evento/CreazioneEvento`;

    const data= {
        idUtente: Id,
        descrizione: Descrizione,
        dataEvento: DataEvento
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
            console.log("post aggiunto");
            return response.text(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionVisualizzaEventoId(Id){
    return fetch(`${BASE_URL}Evento/VisualizzaEvento?idEvento=`+ String(Id))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionGestionePending(IdCuratore, IdPost){
        const url = `${BASE_URL}Utente/GestionePending`;

        const data= {
            idCuratore: IdCuratore,
            idPost: IdPost
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
function ConnectionVisualizzaPending(){
    return fetch(`${BASE_URL}Post/VisualizzaPending`)
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionTuttiPostDiUnUtente(IdUtente){
    return fetch(`${BASE_URL}Post/VisualizzaPostDiUnUtente?IdUtente=`+ String(IdUtente))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionTuttiPostDiUnComune(ComuneDiRef){
    return fetch(`${BASE_URL}Post/VisualizzaPostDiUnComune?Comune=`+ String(ComuneDiRef))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
        });
}
function ConnectionAddItinerario(Id, Descrizione){
    const url = `${BASE_URL}Itinerario/CreazioneItinerario`;

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
                console.log("post aggiunto");
                return response.text(); // Questo ritorna una Promise che si risolve con i dati JSON
            });
}
function ConnectionTextListaItinerari(){
        return fetch(`${BASE_URL}Itinerario/VisualizzaItinerari`)
            .then(response => {
                if (response.status !== 200) {
                    throw new Error('Request failed with status ' + response.status);
                }
                return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
            });
}
function ConnectionTextListaPostInItinerario(IdItinerario){
        return fetch(`${BASE_URL}Itinerario/VisualizzaPostInItinerario?idItinerario=`+ String(IdItinerario))
            .then(response => {
                if (response.status !== 200) {
                    throw new Error('Request failed with status ' + response.status);
                }
                return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
            });
}
function ConnectTextDatiItinerario(IdItinerario){
    return fetch(`${BASE_URL}Itinerario/VisualizzaPostInItinerario?idItinerario=`+ String(IdItinerario))
        .then(response => {
            if (response.status !== 200) {
                throw new Error('Request failed with status ' + response.status);
            }
            return response.json(); // Questo ritorna una Promise che si risolve con i dati JSON
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
function VisualizzaUtenteId(){
    let tepId = document.getElementById('IdVisualizzazioneDati').value;

    ConnectionVisualizzaUtenteId(tepId).then(dati => {
    console.log(dati);
        // Assicurati che gli ID corrispondano agli elementi nel tuo HTML
        document.getElementById('NomeVisuallizzaDati').textContent = String(dati.nome); // Assumi che l'oggetto Utente abbia una proprietà 'nome'
        document.getElementById('CognomeVisualizzaDati').textContent = String(dati.cognome) + " - eta:"; // Assumi che l'oggetto Utente abbia una proprietà 'cognome'
        document.getElementById('EmailVisuallizzaDati').textContent = String(dati.email);
        document.getElementById('ComuneVisualizzaDati').textContent = String(dati.comune) + " / ";
        document.getElementById('RuoloVisuallizzaDati').textContent = String(dati.ruolo) + " / ";
        document.getElementById('etaVisualizzaDati').textContent = String(dati.eta);
    }).catch(error => {
        console.log(dati);
        console.error(error);
    });
}
function CambioRuolo(){
    let tempId = String(document.getElementById('idMR').value);
    let tempRuolo = String(document.getElementById('RuoloMR').value);
    let tempConf = document.getElementById('ModificaRuoloConferma');


    ConnectionModificaRuolo(tempId, tempRuolo).then(text => {
                                                                   tempConf.textContent = text;
                                                               }).catch(error => {
                                                                   console.error('Error:', error);
                                                                   tempConf.textContent = 'Errore durante l\'eliminazione dell\'utente.';
                                                               });
}
function PostBase(){
    let tempId = document.getElementById('IdUtentePost').value;
    let tempDesc = String(document.getElementById('DescrizionePost').value);
    let tempStato = document.getElementById('TextIdUtentePost');

    ConnectionAddPostBase(tempId, tempDesc).then(text => {
        if(text == "non ok"){
        tempStato.textContent = "Post Non Creato utente inadatto";}else{
        tempStato.textContent = "Post Aggiunto";}
        }).catch(error => {
        console.error('Error:', error);
        tempStato.textContent = "Post Non Creato";
        });
}
function EliminaUtente() {
    let temp = document.getElementById('IdEliminaUtente').value;
    let templable = document.getElementById('UtenteEliminato');
    console.log(temp);

    ConnectionDeleteUtente(temp).then(text => {
        templable.textContent = text;
    }).catch(error => {
        console.error('Error:', error);
        templable.textContent = 'Errore durante l\'eliminazione dell\'utente.';
    });
}
function VisualizzaPostId(){
let tepId = document.getElementById('IdPostVisualizza').value;

    ConnectionVisualizzaPostId(tepId).then(dati => {
    console.log(dati);
        // Assicurati che gli ID corrispondano agli elementi nel tuo HTML
        document.getElementById('ContenutoVisualizzaPost').textContent = "id:" + String(dati.id)+ " / Descrizione:" + String(dati.descrizione) + " / pending:" + String(dati.pending);
    }).catch(error => {
        console.log(dati);
        console.error(error);
    });
}
function Evento(){
    let tempId = document.getElementById('IdUtentePostEvento').value;
    let tempDesc = String(document.getElementById('DescrizioneEvento').value);
    let tempData = document.getElementById('DataEvento').value;

    let tempStato = document.getElementById('TextIdEvento');

    ConnectionAddEvento(tempId, tempDesc, tempData).then(text => {
        tempStato.textContent = text;
        }).catch(error => {
        console.error('Error:', error);
        tempStato.textContent = "Evento Non Aggiunto";
        });
}
function VisualizzaEventoId(){
let tepId = document.getElementById('IdVisualizzaEvento').value;

    ConnectionVisualizzaEventoId(tepId).then(dati => {
    console.log(dati);
        // Assicurati che gli ID corrispondano agli elementi nel tuo HTML
        document.getElementById('ContenutoVisualizzaEvento').textContent = "id:" + String(dati.id)+ " / Descrizione:" + String(dati.descrizione) + " / Data Evento: " + String(dati.dataEvento + " / Da Utente: " + String(dati.creatore.nome));
    }).catch(error => {
        console.log(dati);
        console.error(error);
    });

}
function GestionePending(){
    let tempIdCuratore = String(document.getElementById('IdCuratoreGestionePending').value);
    let tempIdPost = String(document.getElementById('IdPostGestionePending').value);
    let tempConf = document.getElementById('TextGestionePending');


    ConnectionGestionePending(tempIdCuratore, tempIdPost).then(text => {
                                                                   tempConf.textContent = text;
                                                               }).catch(error => {
                                                                   console.error('Error:', error);
                                                                   tempConf.textContent = 'Errore durante l\'Aggiornamento dell\'Post.';
                                                               });
}
function VisualizzaPostInPending(){
    let DivVisual = document.getElementById('PostInPending');
    rimuoviTuttiFigli(DivVisual);

    ConnectionVisualizzaPending().then(dati => {
        dati.forEach(oggetto => {
            console.log(oggetto);
            // Crea un elemento label
            const label = document.createElement('label');

            // Corregge l'errore di sintassi nella concatenazione
            label.textContent = "id: " + oggetto.id + " / Desc: " + oggetto.descrizione;

            // Aggiungi un margine per spaziare le label (opzionale)
            label.style.display = 'block';

            // Aggiunge la label al contenitore
            DivVisual.appendChild(label);
        }); // Manca una parentesi chiusa qui

        console.log(dati);
    }).catch(error => {
        // console.log(dati); // Questo dovrebbe essere console.log(error); per loggare l'errore
        console.error(error);
    });
}
function TuttiPostDiUnUtente(){
    let DivVisual = document.getElementById('TuttiPostDiUnUtente');
    let IdUtente = document.getElementById('IdUtenteVisualizzaTuttiPost').value;
    rimuoviTuttiFigli(DivVisual);

    ConnectionVisualizzaPending(IdUtente).then(dati => {
        dati.forEach(oggetto => {
            console.log(oggetto);
            // Crea un elemento label
            const label = document.createElement('label');

            // Corregge l'errore di sintassi nella concatenazione
            label.textContent = "id: " + oggetto.id + " / Desc: " + oggetto.descrizione;

            // Aggiungi un margine per spaziare le label (opzionale)
            label.style.display = 'block';

            // Aggiunge la label al contenitore
            DivVisual.appendChild(label);
        }); // Manca una parentesi chiusa qui

        console.log(dati);
    }).catch(error => {
        // console.log(dati); // Questo dovrebbe essere console.log(error); per loggare l'errore
        console.error(error);
    });
}
function TuttiIPostInComune(){
    let DivVisual = document.getElementById('VisualizzaTuttiIPostInComune');
    let ComuneDiRef = document.getElementById('VisualizzaPostComuni').value;
    rimuoviTuttiFigli(DivVisual);

    ConnectionTuttiPostDiUnComune(ComuneDiRef).then(dati => {
        dati.forEach(oggetto => {
            console.log(oggetto);
            // Crea un elemento label
            const label = document.createElement('label');

            // Corregge l'errore di sintassi nella concatenazione
            label.textContent = "id: " + oggetto.id + " / Desc: " + oggetto.descrizione;

            // Aggiungi un margine per spaziare le label (opzionale)
            label.style.display = 'block';

            // Aggiunge la label al contenitore
            DivVisual.appendChild(label);
        }); // Manca una parentesi chiusa qui

        console.log(dati);
    }).catch(error => {
        // console.log(dati); // Questo dovrebbe essere console.log(error); per loggare l'errore
        console.error(error);
    });
}
function Itinerario(){
    let tempId = document.getElementById('IdUtentePostItinerario').value;
    let tempDesc = String(document.getElementById('DescrizioneItinerario').value);
    let tempStato = document.getElementById('TextrispostaItinerario');

    ConnectionAddItinerario(tempId, tempDesc).then(text => {
                                                     if(text == "non ok"){
                                                     tempStato.textContent = "Itinerario Non Creato utente inadatto";
                                                     }else{
                                                     tempStato.textContent = "Itinerario Aggiunto";}
                                                     }).catch(error => {
                                                     console.error('Error:', error);
                                                     tempStato.textContent = "Itinerario Non Creato";
                                                     });
}
function TuttiItinerari(){
   let DivVisual = document.getElementById('TextListaItinerari');
    rimuoviTuttiFigli(DivVisual);

    ConnectionTextListaItinerari().then(dati => {
        dati.forEach(oggetto => {
            console.log(oggetto);
            // Crea un elemento label
            const label = document.createElement('label');

            // Corregge l'errore di sintassi nella concatenazione
            label.textContent = "id: " + oggetto.id + " / Desc: " + oggetto.descrizione;

            // Aggiungi un margine per spaziare le label (opzionale)
            label.style.display = 'block';

            // Aggiunge la label al contenitore
            DivVisual.appendChild(label);
        }); // Manca una parentesi chiusa qui

        console.log(dati);
    }).catch(error => {
        // console.log(dati); // Questo dovrebbe essere console.log(error); per loggare l'errore
        console.error(error);
    });
}
function ContenutoItinerarioById(){
let ValId = document.getElementById('VisualizzaItinerarioId').value;
let DivVisual0 = document.getElementById('TextItinerarioVisualizzato');
let DivVisual1 = document.getElementById('TextPostContenuti');
    rimuoviTuttiFigli(DivVisual1);

     ConnectionVisualizzaPostId(ValId).then(dati => {
        console.log(dati);
            // Assicurati che gli ID corrispondano agli elementi nel tuo HTML
            DivVisual0.textContent = "id:" + String(dati.id)+ " / Descrizione:" + String(dati.descrizione) + " / pending:" + String(dati.pending);
        }).catch(error => {
            console.log(dati);
            console.error(error);
        });

    ConnectionTextListaPostInItinerario(ValId).then(dati => {
        dati.forEach(oggetto => {
            console.log(oggetto);
            // Crea un elemento label
            const label = document.createElement('label');

            // Corregge l'errore di sintassi nella concatenazione
            label.textContent = "id: " + oggetto.id + " / Desc: " + oggetto.descrizione;

            // Aggiungi un margine per spaziare le label (opzionale)
            label.style.display = 'block';

            // Aggiunge la label al contenitore
            DivVisual1.appendChild(label);
        }); // Manca una parentesi chiusa qui

        console.log(dati);
    }).catch(error => {
        // console.log(dati); // Questo dovrebbe essere console.log(error); per loggare l'errore
        console.error(error);
    });
}
function AggiungiPostAdItinerario(){
        let tempIdPost = document.getElementById('IdUtentePostItinerario').value;
        let tempIdItinerario = String(document.getElementById('DescrizioneItinerario').value);
        let tempStato = document.getElementById('TextrispostaItinerario');

        ConnectionAddItinerario(tempId, tempDesc).then(text => {
                                                         if(text == "non ok"){
                                                         tempStato.textContent = "Itinerario Non Creato utente inadatto";
                                                         }else{
                                                         tempStato.textContent = "Itinerario Aggiunto";}
                                                         }).catch(error => {
                                                         console.error('Error:', error);
                                                         tempStato.textContent = "Itinerario Non Creato";
                                                         });
}

//funzioni di rutine
function rimuoviTuttiFigli(DivBox) {
    while (DivBox.firstChild) {
        DivBox.removeChild(DivBox.firstChild);
    }
}



