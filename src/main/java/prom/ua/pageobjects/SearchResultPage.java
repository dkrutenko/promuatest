package prom.ua.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class SearchResultPage {
    private final SelenideElement categoryButton = $x("//button[@class='br-o-filter categories']");

    public ProductPage selectFirstItem(String item) {
        $x("//div[@data-position-qaid=" + item + "]")
                .shouldBe(visible)
                .click();

        return new ProductPage();
    }

    public SearchResultPage selectRequiredCategoryById(String categoryId) {
        $x("//div[@class='hidden-lg br-sidebar-in']//a[@class='search-category category-" + categoryId + "']")
                .shouldBe(visible)
                .click();

        return this;
    }

    public SearchResultPage clickCategoryButton() {
        categoryButton
                .shouldBe(visible)
                .click();

        return this;
    }
}
