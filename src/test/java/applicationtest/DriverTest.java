package applicationtest;

import com.app.planner.TaskPlanner;
import com.app.planner.pojo.Sprint;
import com.app.planner.service.SprintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by swethat on 24/7/19.
 */
@SpringBootTest(classes={TaskPlanner.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverTest
{

    @Autowired
    private SprintService sprintService;


    @Test
    public void testSprint()
    {
        System.out.println("starting exploration....");
        Sprint sprint = Sprint.builder().id("ONE").taskList(new ArrayList<>()).build();
        sprintService.createSprint(sprint);
        sprintService.displaySprint(sprint);
        System.out.println("ending exploration....");
    }
}
