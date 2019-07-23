package com.app.planner.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.app.planner.pojo.Task;
import com.app.planner.pojo.User;


@Repository
public class UserRepository {

	private HashMap<String, User> userMap;
	private HashMap<String, HashMap<String, List<Task>>> userTaskMap;

	public UserRepository(){
		this.userMap = new HashMap<>();
		this.userTaskMap = new HashMap<>();
	}

	public HashMap<String, User> getUserMap() {
		return userMap;
	}

	public HashMap<String, HashMap<String, List<Task>>> getUserTaskMap() {
		return userTaskMap;
	}

	public void setUserTaskMap(HashMap<String, HashMap<String, List<Task>>> userTaskMap) {
		this.userTaskMap = userTaskMap;
	}

	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}

	public void addUser(User u) {
		this.userMap.put(u.getId(), u);
	}

}
