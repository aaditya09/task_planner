package com.app.planner.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.planner.pojo.Sprint;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.TaskStatus;
import com.app.planner.repository.SprintRepository;


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
		sprintRepository.getSprintOntrackTaskMap().put(sprint.getId(), sprint.getOnTrackTaskList());
	}

	public void deleteSprint(Sprint sprint) {
		sprintRepository.getSprintOntrackTaskMap().remove(sprint.getId());

	}

	public void displaySprint(Sprint sprint) {

		updateAllDelayedTasks(sprint);
		List<Task> onTrack = sprintRepository.getSprintOntrackTaskMap().get(sprint.getId());
		List<Task> delayedTask = sprintRepository.getSprintDelayTaskMap().get(sprint.getId());
		System.out.println("Sprint title => " + sprint.getId());
		if (onTrack.size() > 0) {
			System.out.println("On Track Tasks:");
			for (Task task : onTrack)
				System.out.println(task.getTitle());
		}

		if (delayedTask.size() > 0) {
			System.out.println("Delayed Tasks:");
			for (Task task : delayedTask)
				System.out.println(task.getTitle());
		}

	}

	private void updateAllDelayedTasks(Sprint sprint) {
		List<Task> delayedTaskList = sprint.getOnTrackTaskList().stream()
				.filter(task -> task.getStatus().equals(TaskStatus.COMPLETED)
						&& LocalDateTime.now().toLocalDate().isAfter(task.getDate()))
				.collect(Collectors.toList());

		List<Task> alreadyDelayedTasks = sprintRepository.getSprintDelayTaskMap().get(sprint.getId());
		alreadyDelayedTasks.addAll(delayedTaskList);
		sprintRepository.getSprintDelayTaskMap().put(sprint.getId(), alreadyDelayedTasks);

	}

	public void addTask(Sprint sprint, Task task) {
		List<Task> tasks = sprintRepository.getSprintOntrackTaskMap().getOrDefault(sprint.getId(), new ArrayList<>());
		tasks.add(task);
		sprintRepository.getSprintOntrackTaskMap().put(sprint.getId(), tasks);
		taskService.addTask(sprint, task);

	}

	public void removeTask(Sprint sprint, Task task) {
		List<Task> tasks = sprintRepository.getSprintOntrackTaskMap().getOrDefault(sprint.getId(), new ArrayList<>());
		if (!tasks.isEmpty()) {
			tasks.remove(task);
			sprintRepository.getSprintOntrackTaskMap().put(sprint.getId(), tasks);
			taskService.removeTask(task);
		} else
			System.out.println("cannot remove task");

	}

}
