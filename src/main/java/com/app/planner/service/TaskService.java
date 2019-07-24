package com.app.planner.service;

import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;
import com.app.planner.repository.SprintRepository;
import com.app.planner.repository.TaskRepository;
import com.app.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {


	private  TaskRepository taskRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SprintRepository sprintRepository ;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void addTaskForSprint(Sprint sprint, Task task) {
		taskRepository.addTaskForSprint(sprint,task);
		sprintRepository.addTask(sprint,task);
	}

	private void removeTaskFromAssignee(Task task) {

		taskRepository.removeTaskFromAssignee(task);
	}

	public void assignTask(Task task,User user) {
		taskRepository.assignTask(task,user);
		userRepository.trackTaskType(task,user);
	}

	public void reassignTask(Task task, User user) {

		// /task/{id} with body { fromUser:{id} , toUser:{id}}
		// get task object from db/map with its id , similary get FromUser and toUser pojos and carryon.
		removeTaskFromAssignee(task);
		assignTask(task,user);

	}

	public void addTask(Task task)
	{
		taskRepository.addTask(task);
	}

	public void moveTask(Task task,Sprint sprint)
	{
		// similar to reassign task;
	}

	public Sprint getSprint(Task task) {
		return taskRepository.getTaskMap().getOrDefault(task.getTitle(), null);
	}

}
