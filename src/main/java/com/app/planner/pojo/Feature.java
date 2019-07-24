package com.app.planner.pojo;


import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


@Data
public class Feature extends Task {

	private String summary;
	private Impact impact;

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

	@Autowired
	TaskState testingState;

	@Autowired
	TaskState deployedState;


	@Override
	public TaskState getThirdState() {
		return testingState;
	}

	@Override
	public TaskState getFourthState() {
		return deployedState;
	}

}
