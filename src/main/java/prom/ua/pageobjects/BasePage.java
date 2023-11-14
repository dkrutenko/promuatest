package prom.ua.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage<T extends BasePage<T>> {
    private final SelenideElement searchInput = $x("//input[@name='search_term']");
    private final SelenideElement showSidebarButton = $x("//button[@data-qaid='show_sidebar']");
    private final SelenideElement searchButton = $x("//button[@data-qaid='search_btn']");
    private final SelenideElement goToHomePageButton = $x("//a[@title='prom.ua']");
    private final SelenideElement shoppingCartButton = $x("//button[@data-qaid='shopping_cart']");
    private int distance;

    @Step("BasePage: Send text in search input")
    public T fillSearchField(String text) {
        searchInput.shouldBe(visible)
                .setValue(text);

        return (T) this;
    }

    public T clickOnShowSidebarButton() {
        showSidebarButton.shouldBe(visible)
                .click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Знайти' button")
    public SearchResultPage clickOnSearchButton() {
        searchButton.shouldBe(visible)
                .click();

        return new SearchResultPage();
    }

    @Step("BasePage: Clicked on 'Всі категорії' button")
    public T clickOnAllCategoriesButton() {
        $x("//li[@class='all']//span").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on switch language button")
    public T clickOnSwitchLanguageButton() {
        $x("//button[@data-qaid='lang_menu']").click();

        return (T) this;
    }

    public T selectLanguage(String ua_lang, String ru_lang) {
        $x("//span[contains(@data-qaid, " + ua_lang + "lang)]").scrollIntoView(true).click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'login' button")
    public T clickOnLoginButton() {
        $x("//div[@class='br-th-login ']").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on prom logo")
    public T clickHomePage() {
        goToHomePageButton.shouldBe(visible)
                .click();

        return (T) this;
    }

    @Step("BasePage: Clicked on shopping cart")
    public T clickShoppingCart() {
        shoppingCartButton.shouldBe(visible)
                .click();

        return (T) this;
    }

    @Step("BasePage: perform scroll down to element on 1000 pixels")
    public void srollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0, 1000)", "");
    }
}
