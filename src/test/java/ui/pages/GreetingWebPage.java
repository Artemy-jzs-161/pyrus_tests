package ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class GreetingWebPage {
    private final SelenideElement
            loginButtonElement = $("a[data-ga-event='login|go-to-pyrus|from-header']"),
            blogPageElement = $x("//a[contains(@href, 'stories')]");
    private final ElementsCollection headerMenuElements = $$(".header__menu-item_collapse");

    public GreetingWebPage openPage(String language) {
        open(language);
        return this;
    }

    public GreetingWebPage pressLoginButton() {
        loginButtonElement.click();
        return this;
    }

    public GreetingWebPage pressBlogPage() {
        blogPageElement.click();
        return this;
    }

    public GreetingWebPage checkHeader(List<String> expectedButtons) {
        headerMenuElements.shouldHave(CollectionCondition.texts(expectedButtons));
        return this;
    }
}
