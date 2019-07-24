package com.app.planner.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;
	private String username;

	private Set<Task> tasks ;


}
