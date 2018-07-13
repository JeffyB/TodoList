/**
 * 
 */
package com.jeff.Todo.models;

/**
 * @author Jeff
 *
 */
public class TodoItem {
	private String text;
	private Boolean done;
	private long id;
	private long listId;
	
	public TodoItem(String text) {
		super();
		this.text = text;
		this.done = false;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean isDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getListId() {
		return listId;
	}
	public void setListId(long listId) {
		this.listId = listId;
	}
	

	
}
