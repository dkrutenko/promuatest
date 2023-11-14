package prom.ua.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.*;

public class HomePage extends BasePage<HomePage> {
    private static Random random = new Random();

    private final ElementsCollection forYouItemsList = $$x("//div[@class='M3v0L YKUY6']/following-sibling::div/div");


    @Step("HomePage: Select first available 'for you' item on homepage")
    public HomePage selectRandomForYouItem() {
        srollDown();
        forYouItemsList.shouldHave(sizeNotEqual(0), ofSeconds(20));

        int random_index = random.nextInt(forYouItemsList.size());
        forYouItemsList.get(random_index)
                .shouldBe(visible, ofSeconds(10))
                .click();

        return new HomePage();
    }
}
