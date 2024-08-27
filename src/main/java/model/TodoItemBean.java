package model;

import java.io.Serializable;
import java.time.LocalDate;

public class TodoItemBean implements Serializable{
	private Long id;
	private String title;
	private String username;
	private LocalDate targetDate;
	private boolean isDone;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public LocalDate getTargetDate() {
		return this.targetDate;
	}
	
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsDone() {
		return this.isDone;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
}

