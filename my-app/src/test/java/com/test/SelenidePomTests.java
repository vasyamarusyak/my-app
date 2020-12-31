package com.test;
import com.frameworkjava.SelenidePom;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;


public class SelenidePomTests {
    public static SelenidePom selenidePom = new SelenidePom();

    @BeforeMethod
    public void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void isItemsAdded() {
        selenidePom.addTasks();
        Assert.assertTrue((selenidePom.stateOfTaskField()),"Element exists");
    }


//    @Test
//    public void getQuantityOfTasks() {
//        addItemsToDo();
//        results = $$(listOfTasks).size();
//        //System.out.println("Quantity of tasks is " + results);
//        Assert.assertTrue(results > 0,"There are not any tasks");
//        System.out.println();
//    }
//
//    @Test
//    public void deleteTask() {
//        //System.out.println("Test 3 is started");
//        for(int i=0; i<taskNumber; i++) {
//            $(addingField).val("Task " + i ).pressEnter();
//        }
//        int resultsBeforeDel = $$(listOfTasks).size();
//        //System.out.println("Quantity of tasks before deleting are " + results);
//        Selenide.actions().moveToElement(firstTaskField).perform();
//        $(deleteButton).click();
//        int resultsAfterDel = $$(listOfTasks).size();
//        // System.out.println("Quantity of tasks after deleting are " + results);
//        Assert.assertEquals(resultsBeforeDel-1, resultsAfterDel , "Task is deleted");
//        System.out.println();
//    }
//
//    @Test
//    public void compareQuantity() {
//        //System.out.println("Test 4 is started");
//        for(int i=0; i<taskNumber; i++) {
//            $(addingField).val("Task " + i ).pressEnter();
//        }
//        results = $$(listOfTasks).size();
//        //System.out.println("Quantity of tasks is " + results);
//        int quantity = Integer.parseInt($(quantityOfElements).getText());
//        Assert.assertTrue(results == quantity, "Quantity is equal");
//        //System.out.println();
//    }
}


