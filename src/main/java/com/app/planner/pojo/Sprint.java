package com.app.planner.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Data
@Builder
public class Sprint {

	private String id;
	private List<Task> taskList;


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
