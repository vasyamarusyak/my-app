package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VuePage {
    private SelenideElement addingField = $x("//input[@class='new-todo']");
    private SelenideElement firstTaskField = $x("//ul[@class='todo-list']/li[1]");
    private ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");
    private SelenideElement deleteButton = $x("(//div[@class='view'])[1]/button");
    private SelenideElement quantityOfElements = $x("//span[@class='todo-count']/strong");

    public VuePage addTasks() {
        int taskNumber = 5;
        for (int i = 0; i < taskNumber; i++) {
            $(addingField).val("Task " + i).pressEnter();
        }
        return this;
    }

    public boolean stateOfTaskField() {
        if (listOfTasks.isEmpty()) {
            return false;
        } else
            return true;
    }

    public int getQuantityOfTasks() {
        int quantity = $$(listOfTasks).size();
        return quantity;
    }

    public VuePage deleteTask() {
        Selenide.actions().moveToElement(firstTaskField).perform();
        $(deleteButton).click();
        return this;
    }

    public boolean isTaskDeleted() {
        int resultsBeforeDel = $$(listOfTasks).size();
        deleteTask();
        int resultsAfterDel = $$(listOfTasks).size();
        if (resultsBeforeDel - 1 == resultsAfterDel) {
            return true;
        }
        return false;
    }

    public int getButtomQuantityOfTasks() {
        int quantity = Integer.parseInt($(quantityOfElements).getText());
        return quantity;
    }

    public boolean comparingTasksNumbers() {
        if (getQuantityOfTasks() == getButtomQuantityOfTasks()) {
            return true;
        }
        return false;
    }
}

