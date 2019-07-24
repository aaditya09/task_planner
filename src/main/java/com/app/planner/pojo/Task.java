package com.app.planner.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;



@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private String title;
	private String creator;
	private LocalDate date;
	private TaskStatus status;
	private String type;
	private User assignee;
	private List<Task> subTasks;


	@Autowired
	OpenState openState;

	@Autowired
	InprogressState inprogressState;

	@Autowired
	CompletedState completedState;

	private TaskState currentState = openState;

	public TaskState getSecondState() {
		return  inprogressState;
	}

	public TaskState getThirdState() {
		return completedState;
	}

	public TaskState getFourthState() {
		return null;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
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

}
