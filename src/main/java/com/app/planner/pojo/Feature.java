package com.app.planner.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Feature extends Task {

	private String summary;
	private Impact impact;


	@Autowired
	TestingState testingState;

	@Autowired
	DeployedState deployedState;


	@Override
	public TaskState getThirdState() {
		return testingState;
	}

	@Override
	public TaskState getFourthState() {
		return deployedState;
	}

}
