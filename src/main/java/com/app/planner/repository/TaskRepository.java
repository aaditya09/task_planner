package com.app.planner.repository;

import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class TaskRepository {

	private HashMap<String, Task> taskEntryMap =  new HashMap<>();
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

	public void addTask(Task task)
	{
		this.taskEntryMap.put(task.getId(),task);
	}

	public void removeTaskFromAssignee(Task task) {
		User assignee = task.getAssignee();
		Set<Task> oldUserTasks = assignee.getTasks();
		oldUserTasks.remove(task);
		assignee.setTasks(oldUserTasks);
	}

	public void assignTask(Task task , User user)
	{
		task.setAssignee(user);
		Set<Task> newUserTasks = user.getTasks();
		newUserTasks.add(task);
		user.setTasks(newUserTasks);
	}

	public void addTaskForSprint(Sprint sprint , Task task)
	{
		task.setSprint(sprint);
	}

	public void removeTaskForSprint(Task task) {
		Set<Task> existingTasks = task.getSprint().getTaskList();
		existingTasks.remove(task);
		task.getSprint().setTaskList(existingTasks);
	}
}
