package com.app.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import com.app.planner.repository.TaskRepository;


@Service
public class TaskService {


	private  TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void addTask(Sprint sprint, Task task) {
		taskRepository.getTaskMap().put(task.getTitle(), sprint);
	}

	public void removeTask(Task task) {
		taskRepository.getTaskMap().remove(task.getTitle());
	}

	public Sprint getSprint(Task task) {
		return taskRepository.getTaskMap().getOrDefault(task.getTitle(), null);
	}

}
