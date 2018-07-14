package com.jeff.Todo.models;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
/*@JsonFormat(shape = JsonFormat.Shape.ANY)*/

public class TodoList {


	private List<TodoItem> items;
	private String listName;
	private long id;
	
	public TodoList(String listName) {
		items = new ArrayList<TodoItem>();
		this.listName = listName;
	}

	public List<TodoItem> getItems() {
		return items;
	}

	public void setItems(List<TodoItem> items) {
		this.items = items;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void add(TodoItem newTodoItem) {
		this.items.add(newTodoItem);		
	}
	
}
