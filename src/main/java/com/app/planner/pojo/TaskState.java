package com.app.planner.pojo;

public interface TaskState {

	public void updateState(Task task);

	public TaskStatus getState();

}
