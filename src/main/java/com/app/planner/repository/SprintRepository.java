package com.app.planner.repository;

import java.util.HashMap;
import java.util.List;

import com.app.planner.pojo.Task;
import org.springframework.stereotype.Repository;



@Repository
public class SprintRepository {

	private HashMap<String, List<Task>> sprintOntrackTaskMap;
	private HashMap<String, List<Task>> sprintDelayTaskMap;

	public SprintRepository(){
		this.sprintOntrackTaskMap = new HashMap<>();
		this.sprintDelayTaskMap = new HashMap<>();
	}


	public HashMap<String, List<Task>> getSprintOntrackTaskMap() {
		return sprintOntrackTaskMap;
	}

	public void setSprintOntrackTaskMap(HashMap<String, List<Task>> sprintOntrackTaskMap) {
		this.sprintOntrackTaskMap = sprintOntrackTaskMap;
	}

	public HashMap<String, List<Task>> getSprintDelayTaskMap() {
		return sprintDelayTaskMap;
	}

	public void setSprintDelayTaskMap(HashMap<String, List<Task>> sprintDelayTaskMap) {
		this.sprintDelayTaskMap = sprintDelayTaskMap;
	}

}
