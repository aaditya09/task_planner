package com.app.planner.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Bug extends Task {

	private Severity severity;


	@Autowired
	FixedState fixedState;

	@Override
	public TaskState getThirdState() {
		return fixedState;
	}
}
