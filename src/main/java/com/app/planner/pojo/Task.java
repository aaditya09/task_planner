package com.app.planner.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;



@Data
public class Task {

	private String id;
	private String title;
	private User creator;
	private LocalDate date;
	private TaskStatus status;
	private String type;
	private User assignee;
	private Sprint sprint;
	private LocalDate createdDate;
	private TaskState inprogressState;
	private TaskState completedState;
	private TaskState openState;


	public Task(String id,
				String title,
				User creator,
				LocalDate date,
				TaskStatus status,
				String type,
				User assignee, Sprint sprint, LocalDate createdDate, TaskState currentState)
	{
		this.id = id;
		this.title = title;
		this.creator = creator;
		this.date = date;
		this.status = status;
		this.type = type;
		this.assignee = assignee;
		this.sprint = sprint;
		this.createdDate = createdDate;
		this.currentState = currentState;
	}

/*

	/*@Autowired*//*
	TaskState openState;

	@Autowired
	TaskState inprogressState;

	@Autowired
	TaskState completedState;
*/


	public TaskState getInprogressState() {
		return new InprogressState();
	}

	public void setInprogressState(TaskState inprogressState) {
		this.inprogressState = inprogressState;
	}

	public TaskState getCompletedState() {
		return new CompletedState();
	}

	public void setCompletedState(TaskState completedState) {
		this.completedState = completedState;
	}

	public TaskState getOpenState() {
		return new OpenState();
	}

	public void setOpenState(TaskState openState) {
		this.openState = openState;
	}

	public TaskState getCurrentState() {
		return  currentState;
	}

	private TaskState currentState = new OpenState();

	public TaskState getSecondState() {
		return new InprogressState();
	}

	public TaskState getThirdState() {
		return new CompletedState();
	}

	public TaskState getFourthState() {
		return null;
	}


	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public void updateState() {
		this.currentState.updateState(this);
	}

	public void setCurrentState(TaskState state) {
		this.currentState = state;
	}

	public void printTitle()
	{
		System.out.println("Title => "+getTitle());
	}

}
