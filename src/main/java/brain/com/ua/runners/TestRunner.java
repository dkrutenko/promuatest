package main.java.brain.com.ua.runners;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        timeout = 10000;
        open("https://brain.com.ua/ukr/");
    }

}
