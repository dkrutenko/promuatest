package prom.ua;

import prom.ua.pageobjects.HomePage;
import prom.ua.pageobjects.SearchResultPage;
import prom.ua.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFieldTest extends TestRunner {

    @Test
    public void verifySearchFieldTest() {
        var requiredItem = "Xiaomi Poco";
        var categoryId = "298 ";
        var homePage = new HomePage();

        homePage.fillSearchField(requiredItem)
                .clickOnSearchButton()
                .clickCategoryButton()
                .selectRequiredCategoryById(categoryId);

        var firstItem = new SearchResultPage().getFirstItemFromList();
        var lastItem = new SearchResultPage().getLastItemFromList();

        assertThat(firstItem)
                .as("Test failed: first item should have 'xiaomi poco' in title")
                .contains(requiredItem);

        assertThat(lastItem)
                .as("Test failed: last item should have 'xiaomi poco' in title")
                .contains(requiredItem);
    }
}
