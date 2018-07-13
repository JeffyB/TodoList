package com.jeff.repositories;

import java.util.List;

import com.jeff.Todo.models.TodoList;

public interface TodoListRepository {

		public TodoList getTodoList(Long listId);
		public Long addTodoItem(String itemText, Long listId);
		public Long addTodoList(String listName);
		public void removeTodoList(Long listId);
		public void removeTodoItem(Long itemId);
		public void toggleComplete(Long itemId);
		public void updateItemText(String itemText, Long itemId);
		public void updateListText(String listText, Long listId);
		public List<TodoList> getAllTodoLists();
		
}
