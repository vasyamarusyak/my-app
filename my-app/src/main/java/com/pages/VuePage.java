package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VuePage {
    private SelenideElement addingField = $x("//input[@class='new-todo']");
    private ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");
    private SelenideElement deleteButton = $x("(//div[@class='view'])[1]/button");
    private SelenideElement quantityOfElements = $x("//span[@class='todo-count']/strong");

    public VuePage addTasks(String taskName) {
        addingField.val(taskName).pressEnter();
        return this;
    }

    public int getQuantityOfTasks() {
        return $$(listOfTasks).size();
    }

    public int getButtomQuantityOfTasks() {
        return Integer.parseInt($(quantityOfElements).getText());
    }

    public VuePage deleteTask(String taskName) {
        String taskNameFieldString = "//label[normalize-space(text())='%s']";
        String taskFieldDestroyButtonString = ".//following-sibling::button[@class = 'destroy']";
        SelenideElement formatedTaskNameString = $x(String.format(taskNameFieldString, taskName));
        SelenideElement taskDeleteButton = $x(taskFieldDestroyButtonString);
        Selenide.actions().moveToElement(formatedTaskNameString).moveToElement(taskDeleteButton).click().perform();
        return this;
    }
}

