package prom.ua.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage> {
    public String retrieveItemTitle() {
        return $x("//h1[@data-qaid='product_name']")
                .shouldBe(visible)
                .getText()
                .trim();
    }

    public ProductPage clickBuyProduct() {
        $x("//button[@data-qaid='buy-button']")
                .shouldBe(visible)
                .click();

        return new ProductPage();
    }

    public ProductPage clickCloseCartModal() {
        $x("//button[@data-qaid='close']")
                .shouldBe(visible)
                .click();

        return new ProductPage();
    }
}
