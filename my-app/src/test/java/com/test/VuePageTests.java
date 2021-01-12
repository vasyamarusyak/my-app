package com.test;

import com.pages.VuePage;
import com.steps.VuePageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;


public class VuePageTests {
    public VuePageSteps vuePageSteps = new VuePageSteps();
    public VuePage vuePage = new VuePage();


    @BeforeMethod
    public void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void verifyQuantityOfTasksAfterDeletationTest() {
        ArrayList<String> taskNames = new ArrayList<>();
        taskNames.add("task 0");
        taskNames.add("task 1");
        taskNames.add("task 2");
        vuePageSteps.addTask(taskNames);
        vuePageSteps.verifyDeletationOfTasks(taskNames.size(), "task 2");
    }

    @Test
    public void verifyQuantityOfActiveTasksTest() {
        ArrayList<String> taskNames = new ArrayList<>();
        taskNames.add("task 0");
        taskNames.add("task 1");
        taskNames.add("task 2");
        taskNames.add("task 3");
        taskNames.add("task 4");
        taskNames.add("task 5");
        vuePageSteps.addTask(taskNames);
        vuePageSteps.verifyQuantityOfTasks(taskNames.size(), "task 2");
        vuePageSteps.verifyQuantityOfTasks(taskNames.size(), "task 5");
        vuePageSteps.verifyQuantityOfActiveTasks("task 1");
        vuePageSteps.verifyQuantityOfActiveTasks("task 3");
    }


}


