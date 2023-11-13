package prom.ua.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T extends BasePage<T>> {

    @Step("BasePage: Send text in search field")
    public T fillSearchField(String text) {
        $x("//input[@name='search_term']")
                .shouldBe(visible)
                .setValue(text);

        return (T) this;
    }

    public T clickOnShowSidebarButton() {
        $x("//button[@data-qaid='show_sidebar']")
                .shouldBe(visible)
                .click();

        return (T) this;
    }

    @Step("BasePage: Clicked on 'Знайти' button")
    public SearchResultPage clickOnSearchButton() {
        $x("//button[@data-qaid='search_btn']")
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
}
