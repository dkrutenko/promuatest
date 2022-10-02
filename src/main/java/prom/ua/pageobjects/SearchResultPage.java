package prom.ua.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.*;

public class SearchResultPage {

    private final ElementsCollection goodsList = $$x("//*[@class='br-pp-desc br-pp-ipd-hidden ']");

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

    public String getFirstItemFromList() {
        return goodsList
                .shouldBe(sizeNotEqual(0), ofSeconds(10))
                .stream()
                .map(SelenideElement::getText)
                .collect(toList())
                .stream()
                .findFirst()
                .toString();
    }

    public String getLastItemFromList() {
        return goodsList
                .shouldBe(sizeNotEqual(0), ofSeconds(10))
                .stream()
                .map(SelenideElement::getText)
                .collect(toList())
                .get(goodsList.size() - 1);
    }
}
