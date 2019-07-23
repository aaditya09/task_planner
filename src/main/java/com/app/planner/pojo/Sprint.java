package com.app.planner.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Sprint {

	private String id;
	private List<Task> taskList;

	public Sprint(){
		this.taskList = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Task> getOnTrackTaskList() {
		return taskList;
	}

	public void setOnTrackTaskList(List<Task> onTrackTaskList) {
		this.taskList = onTrackTaskList;
	}

}
