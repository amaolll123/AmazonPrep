package com.amao.todo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="todo")
public class Todo {
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="user")
	private String user;
	
	//@Size(min=6, message="Input At least 6 characters")
	@Column(name="descript")
	private String descript;
	
	@Column(name="targetDate", columnDefinition="date")
	private Date targetDate;
	
	
	@Column(name="done")
	private int done;
	
	public Todo(int id, String user, String desc, Date targetDate, int isDone) {
		super();
		this.id = id;
		this.user = user;
		this.descript = desc;
		this.targetDate = targetDate;
		this.done = isDone;
	}
	
	public Todo(){
		super();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	
	
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id, user, descript, targetDate,
				done);
	}
	
	
}
