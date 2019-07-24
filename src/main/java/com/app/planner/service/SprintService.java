package com.app.planner.service;

import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.TaskStatus;
import com.app.planner.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SprintService {

	private SprintRepository sprintRepository;
	private TaskService taskService;

	@Autowired
	public SprintService(SprintRepository sprintRepository, TaskService taskService) {
		this.sprintRepository = sprintRepository;
		this.taskService = taskService;
	}

	public void createSprint(Sprint sprint) {
		System.out.println("created sprint ");
		sprintRepository.addSprint(sprint);

	}

	public void deleteSprint(Sprint sprint) {

		sprintRepository.deleteSprint(sprint);

	}

	public void displaySprint(Sprint sprint) {

		Set<Task> tasks = sprint.getTaskList();
		Set<Task> delayedTasks = getAllDelayedTasks(tasks);
		tasks.removeAll(delayedTasks);
		System.out.println("Sprint title => " + sprint.getId());
		if (tasks != null && tasks.size() > 0) {
			System.out.println("On Track Tasks:");
			for (Task task : tasks)
				System.out.println(task.getTitle());
		}

		if (delayedTasks.size() > 0) {
			System.out.println("Delayed Tasks:");
			for (Task task : delayedTasks)
				System.out.println(task.getTitle());
		}

	}

	private Set<Task> getAllDelayedTasks(Set<Task> tasks) {
		Set<Task> delayedTaskList =  new HashSet<>();
		if(tasks != null)
		{
			 delayedTaskList = tasks.stream()
					.filter(task -> ( !task.getStatus().equals(TaskStatus.COMPLETED) || !task.getStatus().equals(TaskStatus.DEPLOYED))
							&& LocalDateTime.now().toLocalDate().isAfter(task.getDate()))
					.collect(Collectors.toSet());


		}

		return delayedTaskList;

	}


}
