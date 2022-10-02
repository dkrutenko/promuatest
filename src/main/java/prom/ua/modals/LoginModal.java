package prom.ua.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import prom.ua.pageobjects.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginModal extends BasePage<LoginModal> {

    private final SelenideElement phoneField = $x("//input[@class='input-field phone_mask']");
    private final SelenideElement passwordField = $x("//input[@class='input-field br-login-pass-field']");

    @Step("LoginModal: Filled login fields(phone and password)")
    public LoginModal fillLoginFields(String phone, String password) {
        phoneField.click();
        phoneField.sendKeys(phone);
        passwordField.click();
        passwordField.sendKeys(password);

        return this;
    }

    @Step("LoginModal: Clicked on 'Sign in' button")
    public LoginModal clickOnSignInButton() {
        $x("//form[@class='br-login-form modal-br-login-form']//button[@type='submit']").click();

        return this;
    }

    public String getPhoneEmptyFieldErrorMessage() {
        var emptyPhoneFieldMsg = $x("//label[@class='error error_msg empty_field'][@for='modal-login-phone-field']").getText();

        return emptyPhoneFieldMsg;
    }

    public String getPasswordEmptyFieldErrorMessage() {
        var emptyPasswordFieldMsg = $x("//label[@class='error error_msg empty_field'][@for='modal-login-password-field']").getText();

        return emptyPasswordFieldMsg;
    }

    public String getLoginErrorMessage() {
        var loginErrorMsg = $x("//div[@class='login-error']").getText();

        return loginErrorMsg;
    }
}
