package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VuePage {
    private SelenideElement addingField = $x("//input[@class='new-todo']");
    public String taskFieldString = "//ul[@class='todo-list']/li[%d]";
    public String taskFieldDestroyString = "//ul[@class='todo-list']/li[%d]//button";
    private SelenideElement taskDestroyButton = $x("//button");
    public SelenideElement taskField = formatString(4);
    public SelenideElement taskFieldDestroy = formatDestroyString(4);
    private ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");
    private SelenideElement deleteButton = $x("(//div[@class='view'])[1]/button");
    private SelenideElement quantityOfElements = $x("//span[@class='todo-count']/strong");

    public SelenideElement formatString(int taskNumber){
        String formatedString = String.format(taskFieldString, taskNumber);
        SelenideElement taskField = $x(formatedString);
        this.taskField = taskField;
        return taskField;
    }

    public SelenideElement formatDestroyString(int taskNumber){
        String formatedString = String.format(taskFieldDestroyString, taskNumber);
        SelenideElement taskFieldDestroy = $x(formatedString);
        return taskFieldDestroy;
    }


    public VuePage addTasks() {
        addingField.val("Task ").pressEnter();
        return this;
    }

    public int getQuantityOfTasks() {
        return $$(listOfTasks).size();
    }

    public int getButtomQuantityOfTasks() {
        return Integer.parseInt($(quantityOfElements).getText());
    }

    public VuePage deleteTask() {
        Selenide.actions().moveToElement(taskField).perform();
        taskFieldDestroy.click();
        return this;
    }
}

