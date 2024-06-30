package data.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class AccountsWebPage {
    private final SelenideElement
            loginInputFieldElement = $("#p_email"),
            inputToolTipText = $(".input__tooltipText"),
            passwordInputFieldElement = $("input[data-test-id='inputPassword']");

    public AccountsWebPage enterLogin(String username) {
        loginInputFieldElement.setValue(username).pressEnter();
        return this;
    }

    public AccountsWebPage enterPassword(String password) {
        passwordInputFieldElement.setValue(password).pressEnter();
        return this;
    }

    public AccountsWebPage checkingIncorrectPassword(String value) {
        inputToolTipText.shouldHave(text(value));
        return this;
    }
}
