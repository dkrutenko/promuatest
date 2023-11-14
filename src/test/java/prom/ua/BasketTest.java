package prom.ua;

import org.testng.annotations.Test;
import prom.ua.modals.CartModal;
import prom.ua.pageobjects.HomePage;
import prom.ua.pageobjects.ProductPage;
import prom.ua.runners.TestRunner;

import static org.testng.AssertJUnit.assertTrue;

public class BasketTest extends TestRunner {
    @Test
    public void verifyAddedBasketItems() {
        var homePage = new HomePage();
        var productPage = new ProductPage();
        var cartModal = new CartModal();

        homePage.selectRandomForYouItem();
        var first_expected_item = productPage.retrieveItemTitle();
        productPage.clickBuyProduct()
                .clickCloseCartModal()
                .clickHomePage();

        homePage.selectRandomForYouItem();
        var second_expected_item = productPage.retrieveItemTitle();
        productPage.clickBuyProduct()
                .clickCloseCartModal()
                .clickHomePage();
        homePage.clickShoppingCart();

        var items_in_busket_list = cartModal.retrieveCartItemsList();

        assertTrue(items_in_busket_list.contains(first_expected_item));
        assertTrue(items_in_busket_list.contains(second_expected_item));
    }
}
