package com.app.planner.repository;

import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Set;


@Repository
@Data
public class SprintRepository {



	private HashMap<String,Sprint> sprintMap;

	public SprintRepository(){
		this.sprintMap = new HashMap<>();

	}

	public void addSprint(Sprint sprint)
	{
		this.sprintMap.put(sprint.getId(),sprint);
	}

	public void deleteSprint(Sprint sprint)
	{
		this.sprintMap.remove(sprint.getId());
	}




	public void addTask(Sprint sprint , Task task)
	{
		Set<Task> tasks = sprint.getTaskList();
		tasks.add(task);
		sprint.setTaskList(tasks);
	}

	public void removeTask(Sprint sprint, Task task) {
		Set<Task> tasks = sprint.getTaskList();
		tasks.remove(task);
		sprint.setTaskList(tasks);
	}
}
