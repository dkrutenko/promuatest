package prom.ua;

import prom.ua.pageobjects.HomePage;
import prom.ua.pageobjects.ProductPage;
import prom.ua.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFieldTest extends TestRunner {

    @Test
    public void verifySearchFieldTest() {
        var requiredItem = "Razer Ornata Chroma";
        var actual = "Ігрова клавіатура Razer Ornata Chroma";
        var item_id = "1";
        var homePage = new HomePage();
        var productPage = new ProductPage();

        homePage.fillSearchField(requiredItem)
                .clickOnSearchButton()
                .selectFirstItem(item_id)
                .retrieveItemTitle();

        assertThat(actual)
                .as("Test failed: first item should have " + actual + " in title")
                .isEqualTo(productPage.retrieveItemTitle());
    }
}
