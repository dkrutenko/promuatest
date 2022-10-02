package prom.ua.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T extends BasePage<T>> {

    @Step("BasePage: Sended text in search field")
    public T fillSearchField(String text) {
        $x("//div[@class='header-bottom-in']//*[@type='search']")
                .shouldBe(visible)
                .setValue(text);

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Знайти' button")
    public SearchResultPage clickOnSearchButton() {
        $x("//div[@class='header-bottom-in']//*[@class='search-button-first-form']")
                .shouldBe(visible)
                .click();

        return new SearchResultPage();
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
