package com.app.planner;

import com.app.planner.pojo.Sprint;
import com.app.planner.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Aaditya.t on 24/7/19.
 */

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{

    private SprintService sprintService;

    @Autowired
    public CommandLineAppStartupRunner(SprintService sprintService){
        this.sprintService = sprintService;
    }




    @Override
    public void run(String... strings) throws Exception {

        System.out.println("starting exploration....");
        Sprint sprint = new Sprint();
        sprint.setId("ONE");
        sprintService.createSprint(sprint);
        sprintService.displaySprint(sprint);
        System.out.println("ending exploration....");
    }
}
