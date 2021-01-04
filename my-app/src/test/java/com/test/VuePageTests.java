package com.test;

import com.steps.VuePageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;


public class VuePageTests extends VuePageSteps {
    @BeforeMethod
    public void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void DeletationTaskTest() {
        deleteTaskSteps();
    }

    @Test
    public void compareQuantity() { comparingTaskSteps();
    }
}


