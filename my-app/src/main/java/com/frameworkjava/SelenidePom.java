package com.frameworkjava;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.*;



public class SelenidePom {
    private WebDriver driver;

    private SelenideElement addingField = $x("//input[@class='new-todo']");
    private SelenideElement firstTaskField = $x("//ul[@class='todo-list']/li[1]");
    private ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");
    private SelenideElement deleteButton = $x("(//div[@class='view'])[1]/button");
    private SelenideElement quantityOfElements = $x("//span[@class='todo-count']/strong");
    private int taskNumber = 5;
    private int results;


    public SelenidePom addTasks() {
        //System.out.println("Test 1 is started");
        for (int i = 0; i < taskNumber; i++) {
            $(addingField).val("Task " + i).pressEnter();
        }
        return this;
        // System.out.println("Tasks are added");
    }

    public boolean stateOfTaskField(){
        if(listOfTasks.isEmpty()){
            return false;
        }
        else
            return true;
    }
}
