package com.app.planner.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class Sprint {

	private String id;
	private Set<Task> taskList;

}
