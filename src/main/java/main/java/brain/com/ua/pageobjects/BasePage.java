package main.java.brain.com.ua.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T extends BasePage<T>> {

    private final SelenideElement search = $x("//div[@class='container container-new']//div[@class='search-form header-search-form']");

    @Step("BasePage: Sended text in search field")
    public T fillSearchField(String text) {
        search.click();
        search.clear();
        search.sendKeys(text);

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Знайти' button")
    public T clickOnSearchButton() {
        $x("//div[@class='container container-new']//div[@class='search-form header-search-form']//input[@type='submit']").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Магазини' button ")
    public T clickShopsButton() {
        $x("//li[@class='top-menu-list-item folder']").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Всі категорії' button")
    public T clickOnAllCategoriesButton() {
        $x("//li[@class='all']//span").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on switch language button")
    public T clickOnSwitchLanguageButton() {
        $x("//li[@class='header-language-item ']").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'login' button")
    public T clickOnLoginButton() {
        $x("//div[@class='br-th-login ']").click();

        return (T) this;
    }
}
