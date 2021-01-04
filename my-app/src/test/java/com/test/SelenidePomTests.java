package com.test;
import com.frameworkjava.MainClass;
import com.steps.StepsForSelenidePomTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelenidePomTests extends StepsForSelenidePomTests implements MainClass {
    @Test
    public void TaskDeletationTaskTest() {
        Assert.assertTrue((stepsForCheekDeleteTest()), "Task is not deleted");
    }

    @Test
    public void compareQuantity() {
        Assert.assertTrue(stepsForComparingQuantityTest(), "Quantity is not equal");
    }





}


