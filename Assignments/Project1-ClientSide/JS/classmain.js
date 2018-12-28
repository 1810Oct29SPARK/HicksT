function createNode(element) {
	return document.createElement(element);
}
function append(parent, el) {
	return parent.appendChild(el);
}

const url = "/ExpenseNet/session";


function getYourInfo() {
	axios.get(url)
		.then((response) => {
			let schedule = response.data.events;
			let output = '';
			counter = 1;
				console.log(response);
				output += `
					// <th scope="row">${counter}</th>
					<td>${response.data.firstName}</td>
					<td>${response.data.lastName}</td>
					<td>${response.data.username}</td>
					<td>${response.data.password}</td>
					<td>${response.data.reportsTo}</td>
					`;
					counter++;
			// console.log(response);
			$('#output').html(output);
		})

}

function getNewReimbursement(){
	
	var info = {amount:"100.00", option:"travel(car)"};
	
	output += `
		<td>1236</td>
		<td>${info.amount}</td>
		<td>${info.option}</td>
		<td>Pending</td>
		<td>Muffin Apfler</td>
	`;
}

let user = {};

window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/ExpenseNet/session").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/ExpenseNet/InitPage.html";
		} else {
			//define behavior for user returned
			user = data;
			console.log(data);
			document.getElementById("firstname").innerText = "Welcome, " + user.firstName + " ";
			document.getElementById("lastname").innerText = user.lastName;
		}
	});
	
}




// Pictures
// Pictures
// Pictures
// Pictures
// Pictures
// Pictures
// Pictures
// Pictures
// Pictures


