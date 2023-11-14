package prom.ua.modals;

import prom.ua.pageobjects.BasePage;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;


public class CartModal extends BasePage<CartModal> {
    public List<String> retrieveCartItemsList() {
        var cart_items_list = $$x("//div[@data-testid='product_link']/span")
                .shouldBe(sizeNotEqual(0), ofSeconds(10));

        return cart_items_list.texts();
    }
}
