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
function ConnectAddUtente(){
    return fetch(`${BASE_URL}Test`)
         .then(response => {
         if (response.status !== 200) {
            throw new Error(JSON.stringify(response.json()));
         }
         return response.text();
        });
}

//Funzioni
function AddUtente(){

}