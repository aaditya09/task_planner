package com.app.planner.pojo;


import org.springframework.stereotype.Component;

@Component
public class Bug extends Task {

	private Severity severity;

	@Override
	public TaskState getThirdState() {
		return new FixedState();
	}
}
