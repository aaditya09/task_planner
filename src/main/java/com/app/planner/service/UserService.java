package com.app.planner.service;

import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;
import com.app.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


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



	public void getUserTasks(User user) {
		HashMap<String, Set<Task>> taskMap = userRepository.getUserTaskTypeTrack().getOrDefault(user.getId(),
				new HashMap<>());
		System.out.println("User ==> " + user.getUsername());
		Set<String> taskTypes = taskMap.keySet();
		for (String type : taskTypes) {
			System.out.println("Task Type => " + type);
			Set<Task> taskList = taskMap.getOrDefault(type,new HashSet<>());
			for (Task task : taskList) {
				task.printTitle();
				//System.out.println("Title => " + task.getTitle());
				System.out.println("Sprint => ");
				if (task.getSprint() != null)
					System.out.println(taskService.getSprint(task).getId());

			/*	if (task.getSubTasks() != null && task.getSubTasks().size() != 0) {
					System.out.println("SubTrack");
					for (Task subTask : task.getSubTasks()) {
						System.out.println(subTask.getTitle());
					}

				}*/
			}

		}

	}

}
