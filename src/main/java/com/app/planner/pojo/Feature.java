package com.app.planner.pojo;


import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


@Data
public class Feature extends Task {

	private String summary;
	private Impact impact;
	private TaskState testingState;
	private TaskState deployedState;

/*
	@Autowired
	TaskState testingState;

	@Autowired
	TaskState deployedState;
*/

	@Builder
	public Feature(String id,
				   String title,
				   User creator,
				   LocalDate date,
				   TaskStatus status,
				   String type,
				   User assignee,
				   Sprint sprint,
				   LocalDate createdDate,
				   TaskState currentState, String summary, Impact impact)
	{
		super(id,
			  title,
			  creator,
			  date,
			  status,
			  type,
			  assignee,
			  sprint,
			  createdDate,
			  currentState);
		this.summary = summary;
		this.impact = impact;
	}


	public TaskState getTestingState() {
		return new TestingState();
	}

	public void setTestingState(TaskState testingState) {
		this.testingState = testingState;
	}

	public TaskState getDeployedState() {
		return new DeployedState();
	}

	public void setDeployedState(TaskState deployedState) {
		this.deployedState = deployedState;
	}

	@Override
	public TaskState getThirdState() {
		return new TestingState();
	}

	@Override
	public TaskState getFourthState() {
		return new DeployedState();
	}

}
