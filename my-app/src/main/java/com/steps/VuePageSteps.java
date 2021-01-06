package com.steps;

import com.pages.VuePage;
import org.testng.Assert;

public class VuePageSteps {
    public VuePage vuePage = new VuePage();

    public VuePageSteps addTasksStep(int numberOfTasks) throws IllegalArgumentException {
        if(numberOfTasks <= 0) {
            throw new IllegalArgumentException("Nubmer of tasks should be greather than zero : " + numberOfTasks);
        }else {
            for (int i = 0; i < numberOfTasks; i++) {
                vuePage.addTasks();
            }
        }
        return this;
    }

    public VuePageSteps deleteTasksStep(){
        vuePage.deleteTask();
        return this;
    }

    public void verifyDeletationOfTasks() {
        int resultsBeforeDel = vuePage.getQuantityOfTasks();
        vuePage.deleteTask();
        Assert.assertNotEquals(resultsBeforeDel, vuePage.getQuantityOfTasks(), "Task is not deleted");
    }

    public void verifyQuantityOfTasks() {
        Assert.assertEquals(vuePage.getQuantityOfTasks(), vuePage.getButtomQuantityOfTasks(), "Quantity is not equal");
    }
}
