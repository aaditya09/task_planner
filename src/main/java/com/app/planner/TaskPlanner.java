package com.app.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
public class TaskPlanner {

  //  private CommandLineAppStartupRunner commandLineAppStartupRunner;

    public static void main(String[] args) {
        SpringApplication.run(TaskPlanner.class, args);
    }
}
