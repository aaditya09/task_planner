package com.app.planner.pojo;

import org.springframework.stereotype.Component;

@Component
public interface TaskState {

	public void updateState(Task task);

	public TaskStatus getState();

}
