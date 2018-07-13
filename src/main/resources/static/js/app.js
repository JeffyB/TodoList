/**
 * 
 */

var app = function(document) {
	console.log("app loaded", $);	
	

	
	var makeTodoListsDomTree = function(data){
		var ul = document.createElement("ul");
		for (todoList of data){
			console.log(todoList);
			var li = document.createElement("li");
			var listName = document.createTextNode(todoList.listName);
			li.appendChild(listName);
			ul.appendChild(li);
		}
		console.log(data);
		return ul;
	}
	
	$(document).ready(event=> {
		$.get("lists/").done(data=> {
			var ul = makeTodoListsDomTree(data);
			var div = document.getElementById("app");
			div.appendChild(ul);
		});
	});

}

app(document);
