package com.steps;

import com.pages.VuePage;
import org.testng.Assert;

public class VuePageSteps extends VuePage {
    public VuePage vuePage = new VuePage();

    public void deleteTaskSteps() {
        vuePage.addTasks();
        vuePage.getQuantityOfTasks();
        vuePage.deleteTask();
        vuePage.isTaskDeleted();
        Assert.assertTrue((isTaskDeleted()), "Task is not deleted");
    }

    public void comparingTaskSteps() {
        vuePage.addTasks();
        vuePage.getQuantityOfTasks();
        vuePage.getButtomQuantityOfTasks();
        Assert.assertTrue(comparingTasksNumbers(), "Quantity is not equal");
    }
}
