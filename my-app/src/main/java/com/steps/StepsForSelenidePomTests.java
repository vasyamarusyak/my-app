package com.steps;

import com.frameworkjava.SelenidePom;

public class StepsForSelenidePomTests extends SelenidePom {
    public static StepsForSelenidePomTests selenidePomTests = new StepsForSelenidePomTests();

    public boolean stepsForCheekDeleteTest(){
        addTasks();
        getQuantityOfTasks();
        deleteTask();
        isTaskDeleted();
        return true;
    }

    public boolean stepsForComparingQuantityTest(){
        addTasks();
        getQuantityOfTasks();
        getButtomQuantityOfTasks();
        return true;
    }

}
