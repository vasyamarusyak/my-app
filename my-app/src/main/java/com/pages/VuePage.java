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
        $(addingField).val("Task ").pressEnter();
        return this;
    }

    public int getQuantityOfTasks() {
        int quantity = $$(listOfTasks).size();
        return quantity;
    }

    public int getButtomQuantityOfTasks() {
        int quantity = Integer.parseInt($(quantityOfElements).getText());
        return quantity;
    }

    public VuePage deleteTask() {
        Selenide.actions().moveToElement(firstTaskField).perform();
        $(deleteButton).click();
        return this;
    }
}

