package com.frameworkjava;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;



public class SelenidePom {
    private WebDriver driver;

    private SelenideElement addingField = $x("//input[@class='new-todo']");
    private SelenideElement firstTaskField = $x("//ul[@class='todo-list']/li[1]");
    private ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");
    private SelenideElement deleteButton = $x("(//div[@class='view'])[1]/button");
    private SelenideElement quantityOfElements = $x("//span[@class='todo-count']/strong");
    public int taskNumber = 5;
    public int results;
    public int resultsBeforeDel;
    public int resultsAfterDel;
    public int quantity;





    public SelenidePom addTasks() {
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

    public SelenidePom getQuantityOfTasks() {
        this.results = results;
        results = $$(listOfTasks).size();
        return this;
    }

    public SelenidePom deleteTask() {
        this.resultsBeforeDel = resultsBeforeDel;
        this.resultsAfterDel = resultsAfterDel;
        resultsBeforeDel = $$(listOfTasks).size();
        Selenide.actions().moveToElement(firstTaskField).perform();
        $(deleteButton).click();
        resultsAfterDel = $$(listOfTasks).size();
        return this;
    }

    public SelenidePom getButtomQuantityOfTasks() {
        this.quantity = quantity;
        quantity = Integer.parseInt($(quantityOfElements).getText());
        return this;
    }









}
