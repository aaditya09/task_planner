package com.app.planner.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Story extends Task {
	private String summary;
	private List<Task> subtasks;

}
