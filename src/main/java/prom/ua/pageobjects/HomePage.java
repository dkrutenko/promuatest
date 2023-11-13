package prom.ua.pageobjects;

import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage<HomePage> {
    private static Random random = new Random();

    @Step("HomePage: Select first available 'for you' item on homepage")
    public void selectRandomForYouItem() {
        $x("//span[text()='Для тебе']").scrollIntoView(("{behavior: \"instant\", block: \"center\", inline: \"center\"}"));
        var for_you_items_list = $$x("//div[@class='M3v0L YKUY6']/following-sibling::div/div");
        int random_index = random.nextInt(for_you_items_list.size());
        for_you_items_list.get(random_index).click();
    }
}
