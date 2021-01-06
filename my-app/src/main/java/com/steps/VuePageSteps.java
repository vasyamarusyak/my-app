package com.steps;

import com.pages.VuePage;
import org.testng.Assert;

public class VuePageSteps {
    public VuePage vuePage = new VuePage();

    public void verifyDeletationOfTasks() {
        int taskNumber = 5;
        for (int i = 0; i < taskNumber; i++) {
            vuePage.addTasks();
        }
        int resultsBeforeDel = vuePage.getQuantityOfTasks();
        vuePage.deleteTask();
        int resultsAfterDel = vuePage.getQuantityOfTasks();
        Assert.assertNotEquals(resultsBeforeDel, resultsAfterDel, "Task is not deleted");
    }

    public void verifyQuantityOfTasks() {
        vuePage.addTasks();
        Assert.assertEquals(vuePage.getQuantityOfTasks(), vuePage.getButtomQuantityOfTasks(), "Quantity is not equal");
    }
}
