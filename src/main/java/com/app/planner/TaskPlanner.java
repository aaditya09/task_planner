package com.app.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Aaditya.t on 24/7/19.
 */



@SpringBootApplication
public class TaskPlanner {

  //  private CommandLineAppStartupRunner commandLineAppStartupRunner;

    public static void main(String[] args) {
        SpringApplication.run(TaskPlanner.class, args);
    }
}
