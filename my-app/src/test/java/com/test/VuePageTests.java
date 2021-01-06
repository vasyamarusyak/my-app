package com.test;

import com.steps.VuePageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;


public class VuePageTests {
    public VuePageSteps vuePageSteps = new VuePageSteps();

    @BeforeMethod
    public void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void deletationTaskTest() {
        vuePageSteps.verifyDeletationOfTasks();
    }

    @Test
    public void compareQuantityOfTasksAfterDeletationTest() {
        vuePageSteps.verifyDeletationOfTasks();
        vuePageSteps.verifyQuantityOfTasks();
    }
}


