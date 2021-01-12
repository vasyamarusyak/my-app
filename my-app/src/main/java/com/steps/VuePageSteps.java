package com.steps;

import com.pages.VuePage;
import org.testng.Assert;

import java.util.ArrayList;

public class VuePageSteps {
    public VuePage vuePage = new VuePage();

    public VuePageSteps addTask(ArrayList<String> taskNames) {
        for (String item : taskNames) {
            vuePage.addTask(item);
        }
        return this;
    }

    public VuePageSteps deleteTask(String taskName) {
        vuePage.deleteTask(taskName);
        return this;
    }

    public void verifyDeletationOfTasks(int resultsBeforeDel, String nameOfDeletedTask) {
        deleteTask(nameOfDeletedTask);
        Assert.assertNotEquals(resultsBeforeDel, vuePage.getQuantityOfTasks(), "Task is not deleted");
    }

    public void verifyQuantityOfTasks(int quantityBeforeActions, String taskName) {
        vuePage.deleteTask(taskName);
        Assert.assertTrue(quantityBeforeActions > vuePage.getQuantityOfTasks(), "Increased or stayed equals");
    }

    public void verifyQuantityOfActiveTasks(String taskName) {
        vuePage.showActiveTask();
        int quantityBeforeCheckTask = vuePage.getQuantityOfTasks();
        vuePage.showAllTask();
        vuePage.checkTask(taskName);
        vuePage.showActiveTask();
        Assert.assertTrue(quantityBeforeCheckTask > vuePage.getQuantityOfTasks(), "Decreased or stayed equals");
    }


}
