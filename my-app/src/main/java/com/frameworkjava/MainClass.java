package com.frameworkjava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

public interface MainClass {
    @BeforeMethod
    default void setUp() {
        open("http://todomvc.com/examples/vue/");
    }

    @AfterMethod
    default void tearDown() {
        clearBrowserLocalStorage();
    }
}
