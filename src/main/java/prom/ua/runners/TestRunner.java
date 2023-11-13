package prom.ua.runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class TestRunner {
    WebDriver driver;
    ChromeDriverService chrome_service;

    @Parameters("browser")
    public void setupBrowserPath() {
        String driver_path = "/promuatest/drivers/chromedriver.exe";
        chrome_service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driver_path)).build();
    }

    @BeforeMethod
    public void openHomePage() {
        setupBrowserPath();
        timeout = 10000;

        open("https://prom.ua/ua/");
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void browserClose() {
        getWebDriver().quit();
    }
}
