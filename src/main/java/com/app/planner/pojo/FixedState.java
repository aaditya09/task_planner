package com.app.planner.pojo;


import com.app.planner.exception.InvalidStateException;
import org.springframework.stereotype.Component;

@Component
public class FixedState implements TaskState {

	@Override
	public void updateState(Task task) {
		throw new InvalidStateException("Task is already in fixed state, cannot move to further states");
	}

	@Override
	public TaskStatus getState() {
		return TaskStatus.FIXED;
	}

}
