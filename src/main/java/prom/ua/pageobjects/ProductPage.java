package prom.ua.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage> {
    public String retrieveItemTitle() {
        return $x("//h1[@data-qaid='product_name']")
                .shouldBe(visible)
                .getText()
                .trim();
    }
}
