package com.app.planner.repository;

import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Repository
@Data
public class UserRepository {

	private HashMap<String, User> userMap;
	private HashMap<String, HashMap<String,Set<Task>>> userTaskTypeTrack = new HashMap<>();


	public UserRepository(){
		this.userMap = new HashMap<>();

	}

	public HashMap<String, User> getUserMap() {
		return userMap;
	}


	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}

	public void addUser(User u) {
		this.userMap.put(u.getId(), u);
	}

	public void trackTaskType(Task task , User user)
	{
		HashMap<String,Set<Task>> taskMap = userTaskTypeTrack.getOrDefault(user.getId(),new HashMap<>());
		Set<Task> taskSet = taskMap.getOrDefault(task.getType(),new HashSet<>());
		taskSet.add(task);
		taskMap.put(task.getType(),taskSet);
		userTaskTypeTrack.put(user.getId(),taskMap);
	}

}
