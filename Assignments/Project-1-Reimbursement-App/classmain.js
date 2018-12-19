wondiw.onload = function(){
    let div1 = document.getElementById("div1");
    let p1 = document.createElement("p");
    let node = document.createTextNode("this is new");
    p1.appendChile(node);
    div1.appendChild(p1);
    document.getElementById("divWithText").addEventListener("mousemove", fucntion(event){
        console.log(event.timeStamp);
        document.getElementById("mouseX")
    })
}

let bearJSON = '{"bears":[{"id":4,"name":"Aretha","cave":{"id":56,"name":"Valhalla"}},' +
'{"id":7,"name":"Gandalf","cave":{"id":34,"name":"Isengard"}}]}';
let bearObj = JSON.parse(bearJSON);

function showBears(){
    var bearDiv = document.getElementById("div1");
    let bears = bearObj.bears;
    for (let i = 0; i < bears.length; i++){
        let b = bears[i];
        let newParagraph = document.createElement("p");
        newParagraph.innerText = "mame: "+b.name+" cave: "+ b.cave.name;
        bearDiv.appendChild(newParagraph);
        console.log(b);
    }
}