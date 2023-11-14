package prom.ua.modals;

import com.codeborne.selenide.ElementsCollection;
import prom.ua.pageobjects.BasePage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;


public class CartModal extends BasePage<CartModal> {
    private final ElementsCollection cartItemsList = $$x("//div[@data-testid='product_link']/span");

    public List<String> retrieveCartItemsList() {
        cartItemsList.shouldBe(sizeNotEqual(0), ofSeconds(10));

        return cartItemsList.texts();
    }
}
