package com.app.planner.pojo;


import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
public class Bug extends Task {

	@Builder
	public Bug(String id,
			   String title,
			   User creator,
			   LocalDate date,
			   TaskStatus status,
			   String type,
			   User assignee,
			   Sprint sprint,
			   LocalDate createdDate,
			   TaskState currentState,
			   Severity severity)
	{
		super(id, title, creator, date, status, type, assignee, sprint, createdDate, currentState);
		this.severity = severity;
	}

	private Severity severity;


	@Autowired
	FixedState fixedState;

	@Override
	public TaskState getThirdState() {
		return fixedState;
	}
}
