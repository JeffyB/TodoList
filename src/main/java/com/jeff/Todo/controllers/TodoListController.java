package com.jeff.Todo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.Todo.models.TodoList;
import com.jeff.repositories.TodoListRepository;

@Controller
@RequestMapping("lists")
public class TodoListController {
	private TodoListRepository todoListRepository;
	
	public TodoListController (TodoListRepository todoListRepository) {
		this.todoListRepository =  todoListRepository;
	}
	
	@GetMapping
	@ResponseBody
	public List<TodoList> getAllTodoLists() {
		return todoListRepository.getAllTodoLists();
	}
				
	@GetMapping("create")
	@ResponseBody
	public Long createList (@RequestParam("name") String listName) {
		Long newListId = todoListRepository.addTodoList(listName);
		return newListId; 
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public TodoList getTodoListById (@PathVariable("id") Long id) {
		TodoList list = todoListRepository.getTodoList(id);
		return list;
	}
}
