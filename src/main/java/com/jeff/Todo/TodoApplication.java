package com.jeff.Todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeff.Todo.models.TodoList;
import com.jeff.repositories.TodoListRepository;
import com.jeff.repositories.TodoListRepositoryStubImpl;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	@Bean
	public TodoListRepository getRepositoryStub() {
		TodoListRepository newStub = new TodoListRepositoryStubImpl();
		populateWithTestData(newStub);
		return newStub;
	}
	
	private void populateWithTestData(TodoListRepository todoListRepository) {
		Long exampleTodoList1Id = todoListRepository.addTodoList("Todo List 1");
		todoListRepository.addTodoItem("Item 1", exampleTodoList1Id);
		Long exampleTodoItem2Id = todoListRepository.addTodoItem("Item 2", exampleTodoList1Id);
		todoListRepository.toggleComplete(exampleTodoItem2Id);
		
		Long exampleTodoList2Id = todoListRepository.addTodoList("Todo List 2");
		todoListRepository.addTodoItem("Item 1", exampleTodoList2Id);
		todoListRepository.addTodoItem("Item 2", exampleTodoList2Id);
		System.out.println(todoListRepository.getAllTodoLists());
		System.out.println(exampleTodoList1Id);
		
	}
	
}

