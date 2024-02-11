const BASE_URL = 'http://localhost:8080/';
const SHOWCASE_MODE = true;







//Connection List
function TestConnection(){
    return fetch(`${BASE_URL}Test`)
         .then(response => {
         if (response.status !== 200) {
            throw new Error(JSON.stringify(response.json()));
         }
         return response.text();
        });
}

//Funzioni
function TestSing(){
     var label = document.getElementById('Test');

        TestConnection().then(result => {
            label.textContent = result;
        }).catch(error => {
            console.error('Errore nella fetch:', error);
            label.textContent = 'Non Connesso';
        });
}
