package com.app.planner.pojo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;



@Data
public class Story extends Task {
	private String summary;
	private List<Task> subTasks;

	@Override
	public void printTitle()
	{
		System.out.println("Title => "+getTitle());
		System.out.println("SubTrack:");
		subTasks.forEach(task -> {
			task.printTitle();
		});
	}

	@Builder
	public Story(String id,
				 String title,
				 User creator,
				 LocalDate date,
				 TaskStatus status,
				 String type,
				 User assignee,
				 Sprint sprint,
				 LocalDate createdDate,
				 TaskState currentState, String summary, List<Task> subTasks)
	{
		super(id,
			  title,
			  creator,
			  date,
			  status,
			  type,
			  assignee,
			  sprint,
			  createdDate,
			  currentState);
		this.summary = summary;
		this.subTasks = subTasks;
	}
	/*	@Override
	public String getTitle() {

		System.out.println("TitlegetTitle());

	}*/

}
