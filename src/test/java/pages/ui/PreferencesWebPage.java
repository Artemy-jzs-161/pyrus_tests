package pages.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class PreferencesWebPage {
    private final SelenideElement
            blackThemeRadioButtonElement = $x("/html/body/div/div[1]/div/main/div/div[2]/div[2]/ul/li[2]/label/span[1]"),
            pageContentElement = $(".pageContent");

    public PreferencesWebPage selectBlackTheme() {
        blackThemeRadioButtonElement.click();
        return this;
    }

    public PreferencesWebPage checkBackgroundColor(String colorNumber) {
        pageContentElement.shouldHave(cssValue("background-color", colorNumber));
        return this;
    }
}
