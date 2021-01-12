package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VuePage {
    private SelenideElement addingField = $x("//input[@class='new-todo']");
    public ElementsCollection listOfTasks = $$x("//ul[@class='todo-list']/li");

    public VuePage addTask(String taskName) {
        addingField.val(taskName).pressEnter();
        return this;
    }

    public int getQuantityOfTasks() {
        return $$(listOfTasks).size();
    }

    public VuePage deleteTask(String taskName) {
        $x(String.format("//label[normalize-space(text())='%s']", taskName)).click();
        $x(String.format("//label[normalize-space(text())='%s']/following-sibling::button", taskName)).click();
        return this;
    }

    public VuePage checkTask(String taskName) {
        $x(String.format("//label[normalize-space(text())='%s']", taskName)).click();
        $x(String.format("//label[normalize-space(text())='%s']/parent::div/input", taskName)).click();
        return this;
    }

    public VuePage showActiveTask() {
        $x(("//a[contains(@href,'active')]")).click();
        return this;
    }

    public VuePage showAllTask() {
        $x(("//a[contains(@href,'all')]")).click();
        return this;
    }


}

