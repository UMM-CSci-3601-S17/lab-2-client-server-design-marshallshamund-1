window.onload = function(){
    console.log("Loading process is complete");

    var element = document.getElementById('getAllTodos');
    element.addEventListener("click", getAllTodos, true);
}

//Get all todos
var getAllTodos = function(){
    var OurClient = new HttpClient();
    OurClient.get("/api/todos", function(returned_json){
        document.getElementById('jsonDump').innerHTML= returned_json;
    });
}


// var newPage = null;

// function testDawn(selection, urlAddOn){
//
//     var newPage = "http://localhost:4567/api/todos" + selection + urlAddOn;
//
//     if(selection == 'id') {
//         newPage = "http://localhost:4567/api/todos" + urlAddOn;
//     }
//
//
//     return newPage;
// }
var newPage = "http://localhost:4567/api/todos"

function filterList() {
    var selection = document.getElementById('options').value;
    var urlAddOn = document.getElementById("redirect").value;
    var newPage = urlCreator(selection, urlAddOn);
    presentData(newPage);
}

function urlCreator(selection, urlAddOn){
    var newPage = "http://localhost:4567/api/todos?" + selection + "=" + urlAddOn;

    if(selection == 'id') {
        newPage = "http://localhost:4567/api/todos" + urlAddOn;
    }
  return newPage;
}

function presentData(newPage) {
    var Ourclient = new HttpClient();
    Ourclient.get(newPage, function (returned_json) {
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

/**

 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
    // We'll take a URL string, and a callback function.
    this.get = function(aUrl, aCallback){
        var anHttpRequest = new XMLHttpRequest();

        // Set a callback to be called when the ready state of our request changes.
        anHttpRequest.onreadystatechange = function(){

            /**
             * Only call our 'aCallback' function if the ready state is 'DONE' and
             * the request status is 200 ('OK')
             *
             * See https://httpstatuses.com/ for HTTP status codes
             * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
             *  for XMLHttpRequest ready state documentation.
             *
             */
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        }

        anHttpRequest.open("GET", aUrl, true);
        anHttpRequest.send(null);
    }
}
