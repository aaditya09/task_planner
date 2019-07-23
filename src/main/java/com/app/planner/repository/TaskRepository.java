package com.app.planner.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import com.app.planner.pojo.Sprint;


@Repository
public class TaskRepository {

	private HashMap<String, Sprint> taskMap;

	public TaskRepository(){
		this.taskMap = new HashMap<>();
	}

	public HashMap<String, Sprint> getTaskMap() {
		return taskMap;
	}

	public void setTaskMap(HashMap<String, Sprint> taskMap) {
		this.taskMap = taskMap;
	}

}
