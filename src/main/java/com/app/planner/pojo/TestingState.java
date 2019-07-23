package com.app.planner.pojo;


import org.springframework.stereotype.Component;

@Component
public class TestingState implements TaskState {

	@Override
	public void updateState(Task task) {
		TaskState nextState = task.getFourthState();
		System.out.println("Task is moved to " + nextState.getState());
		task.setCurrentState(nextState);

	}

	@Override
	public TaskStatus getState() {
		return TaskStatus.TESTING;
	}
}
