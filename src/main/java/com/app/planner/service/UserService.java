package com.app.planner.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;
import com.app.planner.repository.UserRepository;


@Service
public class UserService {

	private UserRepository userRepository;
	private TaskService taskService;

	@Autowired
	public UserService(UserRepository userRepository, TaskService taskService ) {
		this.userRepository = userRepository;
		this.taskService = taskService;
	}

	public void addUser(User user) {
		userRepository.addUser(user);
	}

	public void addTasktoUser(Task task, User user) {

		User oldUser = task.getAssignee();
		if (oldUser != null) {
			userRepository.getUserTaskMap().get(oldUser.getId()).get(task.getType()).remove(task);

		}

		task.setAssignee(user);
		HashMap<String, List<Task>> taskMap = userRepository.getUserTaskMap().getOrDefault(user.getId(),
				new HashMap<>());
		List<Task> tasks = taskMap.getOrDefault(task.getType(), new ArrayList<>());
		tasks.add(task);
		taskMap.put(task.getType(), tasks);
		userRepository.getUserTaskMap().put(user.getId(), taskMap);
	}

	public void getUserTasks(User user) {
		HashMap<String, List<Task>> taskMap = userRepository.getUserTaskMap().getOrDefault(user.getId(),
				new HashMap<>());
		System.out.println("User ==> " + user.getUsername());
		Set<String> taskTypes = taskMap.keySet();
		for (String type : taskTypes) {
			System.out.println("Task Type => " + type);
			List<Task> taskList = taskMap.get(type);
			for (Task task : taskList) {
				System.out.println("Title => " + task.getTitle());
				System.out.println("Sprint => ");
				if (taskService.getSprint(task) != null)
					System.out.println(taskService.getSprint(task).getId());

				if (task.getSubTasks() != null && task.getSubTasks().size() != 0) {
					System.out.println("SubTrack");
					for (Task subTask : task.getSubTasks()) {
						System.out.println(subTask.getTitle());
					}

				}
			}

		}

	}

}
