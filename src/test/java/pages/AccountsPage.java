package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class AccountsPage {
    private final SelenideElement
            loginInputFieldElement = $("#p_email"),
            passwordInputFieldElement = $("input[data-test-id='inputPassword']");

    public AccountsPage enterLogin(String username) {
        loginInputFieldElement.setValue(username).pressEnter();
        return this;
    }

    public AccountsPage enterPassword(String password) {
        passwordInputFieldElement.setValue(password).pressEnter();
        return this;
    }
}
