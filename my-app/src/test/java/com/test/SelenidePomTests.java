package com.test;
import com.frameworkjava.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelenidePomTests extends MainClass {

    @Test
    public void isItemsAdded() {
        selenidePom.addTasks();
        Assert.assertTrue((selenidePom.stateOfTaskField()), "Element exists");
    }

    @Test
    public void checkQuantityOfTasks() {
        selenidePom.addTasks();
        selenidePom.getQuantityOfTasks();
        Assert.assertTrue(selenidePom.results > 0, "There are not any tasks");
    }

    @Test
    public void checkDelegationOfTask() {
        selenidePom.addTasks();
        selenidePom.deleteTask();
        Assert.assertEquals(selenidePom.resultsBeforeDel - 1, selenidePom.resultsAfterDel, "Task is deleted");
    }

    @Test
    public void compareQuantity() {
        selenidePom.addTasks();
        selenidePom.getQuantityOfTasks();
        selenidePom.getButtomQuantityOfTasks();
        Assert.assertTrue(selenidePom.results == selenidePom.quantity, "Quantity is equal");
    }

}


