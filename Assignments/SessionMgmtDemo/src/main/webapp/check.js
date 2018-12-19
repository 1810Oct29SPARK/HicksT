/**
 * 
 */

let User = {};

window.onload = function() {
	populateUser();
}

function populateUser() {
	// send a GET request to localhost:7001/SessionMgmtDemo/Session
	fetch("http://localhost:7001/SessionMgmtDemo/session").then(function(response) {
		return response.json();
	}).then(function(data) {

		// parse the response as JSON
		
		// check whether there is a valid user returned

		// define behavior for no user returned

		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/SessionMgmtDemo/login";
		
		} else {
			// define behavior for user returned
			user = data;
			document.getElementById("username").innerText = "Username: " + user.username;
			document.getElementById("firstname").innerText = "First Name: " + user.firstname;
			document.getElementById("lastname").innerText = "Last Name: " + user.lastname;
			document.getElementById("email").innerText = "Email: " + user.email;
		}

	});
}