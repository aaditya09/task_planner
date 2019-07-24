package applicationtest;

import com.app.planner.TaskPlanner;
import com.app.planner.pojo.*;
import com.app.planner.service.SprintService;
import com.app.planner.service.TaskService;
import com.app.planner.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by swethat on 24/7/19.
 */
@SpringBootTest(classes={TaskPlanner.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverTest
{

    @Autowired
    private SprintService sprintService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @Autowired
    private OpenState openState;

    @Test
    public void testSprint()
    {
        System.out.println("creating user");
        User user = User.builder().username("user1").id("1").tasks(new HashSet<>()).build();
        userService.addUser(user);

        System.out.println("assigning feature task for the user");
        Task task1 = Feature.builder().creator(user).status(TaskStatus.OPEN).type("Feature").impact(Impact.LOW).summary("task1 summary").date(
                LocalDate.of(2014, Month.JANUARY, 1)).createdDate( LocalDate.of(2013, Month.DECEMBER, 25)).currentState(openState).title("Feature 1").build();

        taskService.addTask(task1);

        taskService.assignTask(task1,user);


        System.out.println("assigning feature task for the user");
        List<Task> subTasks = new ArrayList<>();
        subTasks.add(task1);
        Task task2 = Story.builder().creator(user).status(TaskStatus.OPEN).type("Story").summary("task2 summary").date(
                LocalDate.of(2014, Month.JANUARY, 2)).title("Story 1").subTasks(subTasks).createdDate( LocalDate.of(2013, Month.DECEMBER, 25)).build();

        taskService.addTask(task2);

        taskService.assignTask(task2,user);

        System.out.println("printing tasks of the user");
        userService.getUserTasks(user);


        System.out.println("Creating sprint..");
        Sprint sprint = Sprint.builder().id("ONE").taskList(new HashSet<>()).build();
        sprintService.createSprint(sprint);

        System.out.println("assign tasks for sprint ");
        taskService.addTaskForSprint(sprint,task1);
        taskService.addTaskForSprint(sprint,task2);

        //task2.

        System.out.println("adding tasks to the sprint");
       // sprintService.addTask(sprint,task);
        System.out.println("displaying sprint..");


         // Task Assignment
        /* ===========================================================================*/
        System.out.println("\n========== Initial Assignee ===========\n");
        System.out.println("Assignee for task 1: " + task1.getAssignee().getUsername());

        System.out.println("\n========== Initial User 1 tasks ===========\n");
        System.out.println(user.getTasks());
        System.out.println("\n=========================================\n");


        User user2 = User.builder().username("user2").id("2").tasks(new HashSet<>()).build();

        System.out.println("\n========== Initial User 2 tasks ===========\n");
        System.out.println(user2.getTasks());
        taskService.assignTask(task1, user2);
        System.out.println("\n New Assignee for task 1: " + task1.getAssignee().getUsername());

        System.out.println("\n========== Final User 2 tasks ===========\n");
        System.out.println(user2.getTasks());
        System.out.println("\n=========================================\n");

        /*===============================================================================*/


        // Remove tasks from the sprint
        /*===============================================================================*/

        System.out.println("\n========== Initial Sprint1 tasks ==========\n");
        sprintService.displaySprint(sprint);

        Sprint sprint2 = Sprint.builder().id("TWO").taskList(new HashSet<>()).build();

        sprintService.createSprint(sprint2);

        System.out.println("\n========== Initial Sprint2 tasks ==========\n");
        sprintService.displaySprint(sprint2);

        System.out.println("\n========== Moving task1 to Sprint2  ==========\n");
        taskService.moveTask(task1, sprint2);

        System.out.println("\n========== Final Sprint1 tasks ==========\n");
        sprintService.displaySprint(sprint);

        System.out.println("\n========== Final Sprint2 tasks ==========\n");
        sprintService.displaySprint(sprint2);
        /*===============================================================================*/


        // State updation
        /*===============================================================================*/

        /*===============================================================================*/

      //  task1.updateState();
        /* task1.updateState();
        task1.updateState();
        task1.updateState();
        *///task1.setStatus(TaskStatus.COMPLETED);

        //sprintService.displaySprint(sprint);

    }
}

//follow up explore on how to use inheritance in hibernate.
//add test code for changing assignee of tasks - and check getUsertasks for both of them
//remove task for sprint - same approach for addTaskForSprint
// check the state updated - not happening giving null pointer.