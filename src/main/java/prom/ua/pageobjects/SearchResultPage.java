package prom.ua.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class SearchResultPage {
    public ProductPage selectFirstItem(String item) {
        $x("//div[@data-position-qaid="+item+"]")
                .shouldBe(visible)
                .click();

        return new ProductPage();
    }

    public SearchResultPage selectRequiredCategoryById(String categoryId) {
        $x("//div[@class='hidden-lg br-sidebar-in']//a[@class='search-category category-"+categoryId+"']")
                .shouldBe(visible)
                .click();

        return this;
    }

    public SearchResultPage clickCategoryButton() {
        $x("//button[@class='br-o-filter categories']")
                .shouldBe(visible)
                .click();

        return this;
    }
}
