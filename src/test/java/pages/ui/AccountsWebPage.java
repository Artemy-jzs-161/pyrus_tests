package pages.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AccountsWebPage {
    private final SelenideElement
            loginInputFieldElement = $("#p_email"),
            inputToolTipText = $(".input__tooltipText"),
            titleCreateCompanyElement = $x("//h1"),
            passwordInputFieldElement = $("input[data-test-id='inputPassword']");

    public AccountsWebPage enterLogin(String username) {
        loginInputFieldElement.setValue(username).pressEnter();
        return this;
    }

    public AccountsWebPage enterPassword(String password) {
        passwordInputFieldElement.setValue(password).pressEnter();
        return this;
    }

    public AccountsWebPage checkLoginWithIncorrectPassword(String value) {
        inputToolTipText.shouldHave(text(value));
        return this;
    }

    public AccountsWebPage checkLoginWithIncorrectEmail(String value) {
        titleCreateCompanyElement.shouldHave(text(value));
        return this;
    }
}
