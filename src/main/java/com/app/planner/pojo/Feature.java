package com.app.planner.pojo;


import org.springframework.stereotype.Component;

@Component
public class Feature extends Task {

	private String summary;
	private Impact impact;

	@Override
	public TaskState getThirdState() {
		return new TestingState();
	}

	@Override
	public TaskState getFourthState() {
		return new DeployedState();
	}

}
