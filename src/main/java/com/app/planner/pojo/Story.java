package com.app.planner.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Story extends Task {
	private String summary;
	private List<Task> subtasks;

	public Story(){
		this.subtasks = new ArrayList<>();
	}
}
