/**
 * 
 */

var app = function(document) {
	console.log("app loaded", $);	
	

	
	var makeTodoListsDomTree = function(data){

		var todosDiv = document.createElement("div");
		var contentCount = 1
		
		for (var todoList of data){
			var cardDiv = document.createElement("div");
			cardDiv.className = "card";
			
			//Create Header
			var cardHeaderDiv = document.createElement("div");
			cardHeaderDiv.className = "card-header";
			cardHeaderDiv.setAttribute("id", "heading" + contentCount);
			var headerSize = document.createElement("h5");
			headerSize.className = "mb-0";
			var headerButton = document.createElement("button");
			headerButton.setAttribute("class", "btn btn-link collapsed"); 
			headerButton.setAttribute("data-toggle", "collapse");
			headerButton.setAttribute("data-target", "#collapse" + contentCount);
			headerButton.setAttribute("aria-expanded", "False");
			headerButton.setAttribute("aria-controls", "collapse" + contentCount);
			var listName = document.createTextNode(todoList.listName);
			
			//Attach header nodes together here
			headerButton.appendChild(listName);
			headerSize.appendChild(headerButton);
			cardHeaderDiv.appendChild(headerSize);
			cardDiv.appendChild(cardHeaderDiv);
			
			//Create Body (ul)
			var collapsibleBody = document.createElement("div");
			collapsibleBody.setAttribute("id", "collapse" + contentCount);
			collapsibleBody.setAttribute("class", "collapse"); 
			collapsibleBody.setAttribute("aria-labelledby", "heading" + contentCount);
			collapsibleBody.setAttribute("data-parent", "#accordion");
			var itemBody = document.createElement("div");
			itemBody.className = ("card-body");
			
			
			//Create Item Nodes (li)
			for (var item of todoList.items){
				var li = document.createElement("li");
				var itemText = document.createTextNode(item.text);
				li.appendChild(itemText);
				itemBody.appendChild(li);
			}			
			
			//Attach body nodes together here
			collapsibleBody.appendChild(itemBody);
			cardDiv.appendChild(collapsibleBody);			
			todosDiv.appendChild(cardDiv);
			
			contentCount++;
		}
		

		
		return todosDiv;
	}
	
	$(document).ready(event=> {
		$.get("lists/").done(data=> {
			var panelsDiv = makeTodoListsDomTree(data);
			var div = document.getElementById("app");
			div.setAttribute("id", "accordion");
			div.appendChild(panelsDiv);
		});
	});

}

app(document);
