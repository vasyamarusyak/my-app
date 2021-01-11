package com.steps;

import com.pages.VuePage;
import org.testng.Assert;
import java.util.ArrayList;

public class VuePageSteps {
    public VuePage vuePage = new VuePage();
    public ArrayList<String> taskNames = new ArrayList<>();

    public VuePageSteps addTasks(ArrayList<String> taskNames) {
        taskNames.add("task 0");
        taskNames.add("task 1");
        taskNames.add("task 2");
        for (int i = 0; i < taskNames.size(); i++) {
            vuePage.addTasks(taskNames.get(i));
        }
        return this;
    }

    public VuePageSteps deleteTask() {
        vuePage.deleteTask("");
        return this;
    }

    public void verifyDeletationOfTasks() {
        int resultsBeforeDel = vuePage.getQuantityOfTasks();
        vuePage.deleteTask("task 0");
        Assert.assertNotEquals(resultsBeforeDel, vuePage.getQuantityOfTasks(), "Task is not deleted");
    }

    public void verifyQuantityOfTasks() {
        Assert.assertEquals(vuePage.getQuantityOfTasks(), vuePage.getButtomQuantityOfTasks(), "Quantity is not equal");
    }
}
