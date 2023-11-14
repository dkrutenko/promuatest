package prom.ua.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage> {
    private final SelenideElement itemTitle = $x("//h1[@data-qaid='product_name']");
    private final SelenideElement buyButton = $x("//button[@data-qaid='buy-button']");
    private final SelenideElement closeCartButton = $x("//button[@data-qaid='close']");

    public String retrieveItemTitle() {
        return itemTitle.shouldBe(visible)
                .getText()
                .trim();
    }

    public ProductPage clickBuyProduct() {
        buyButton.shouldBe(visible)
                .click();

        return new ProductPage();
    }

    public ProductPage clickCloseCartModal() {
        closeCartButton.shouldBe(visible)
                .click();

        return new ProductPage();
    }
}
