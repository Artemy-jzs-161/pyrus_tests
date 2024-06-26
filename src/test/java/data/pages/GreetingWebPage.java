package data.pages;

import com.codeborne.selenide.*;
import data.enums.Language;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GreetingWebPage {
    private final SelenideElement
            loginButtonElement = $("a[data-ga-event='login|go-to-pyrus|from-header']");

    public GreetingWebPage openPage(Language language) {
        open(language.url);
        return this;
    }

    public GreetingWebPage pressLoginButton() {
        loginButtonElement.click();
        return this;
    }
}

