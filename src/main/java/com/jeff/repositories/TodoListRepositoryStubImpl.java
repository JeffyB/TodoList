package com.jeff.repositories;

import java.util.ArrayList;
import java.util.List;

import com.jeff.Todo.models.TodoItem;
import com.jeff.Todo.models.TodoList;

public class TodoListRepositoryStubImpl implements TodoListRepository{
	
	private static List <TodoList> todoLists = new ArrayList <TodoList> ();
	private static List <TodoItem> todoItems = new ArrayList <TodoItem> ();
	private static long objectKey = 1; 
	public static int n = 0;
	private static long getObjectKey() {
		return objectKey++;
	}
	
	public TodoListRepositoryStubImpl() {
		System.out.println("This bean has been constructed " + ++n + " times.");
	}
	
	@Override
	public List<TodoList> getAllTodoLists() {
		return todoLists;
	}
	
	@Override
	public TodoList getTodoList(Long listId) {
		for (TodoList list: todoLists) {
			
			if (list.getId() == listId) {
				return list;
			}
		}
		return null;
	}

	@Override
	public Long addTodoItem(String itemText, Long listId) {

		long itemId = getObjectKey();
		TodoItem newTodoItem = new TodoItem(itemText);
		newTodoItem.setId(itemId);
		newTodoItem.setListId(listId);
		todoItems.add(newTodoItem);
		return itemId;
	}

	@Override
	public Long addTodoList(String listName) {
		long listId = getObjectKey();
		TodoList newTodoList = new TodoList(listName);
		newTodoList.setId(listId);
		todoLists.add(newTodoList);
		return listId;
	}

	@Override
	public void removeTodoList(Long listId) {
		for (TodoList list: todoLists) {
			if (list.getId() == listId) {
				todoLists.remove(list);
			}
		}
	}

	@Override
	public void removeTodoItem(Long itemId) {
		for (TodoItem item: todoItems) {
			if (item.getId() == itemId) {
				todoItems.remove(item);
			}
		}
	}

	@Override
	public void toggleComplete(Long itemId) {
		for (TodoItem item: todoItems) {
			if (item.getId() == itemId) {
				boolean doneStatus = !item.isDone();
				item.setDone(doneStatus);
			}
		}
	}

	@Override
	public void updateItemText(String itemText, Long itemId) {
		for (TodoItem item: todoItems) {
			if (item.getId() == itemId) {
				item.setText(itemText);;
			}
		}
	}

	@Override
	public void updateListText(String listText, Long listId) {
		for (TodoList list: todoLists) {
			if (list.getId() == listId) {
				list.setListName(listText);
			}
		}
	}

}
