package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class MobilePage {
    private final SelenideElement
            buttonLoginElement = $(AppiumBy.id("net.papirus.androidclient:id/login_tv")),
            emailFieldElement = $(AppiumBy.id("net.papirus.androidclient:id/lf_sp_email")),
            nextButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/al_next")),
            typePasswordButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/al_type_password")),
            passwordFieldElement = $(AppiumBy.id("net.papirus.androidclient:id/lf_ep_pass")),
            next2ButtonElement = $(xpath("(//android.widget.Button[@resource-id=\"net.papirus.androidclient:id/al_next\"])[2]\n")),
            next3ButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_tab_lists_image")),
            knowledgeButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_tab_knowledge_base")),
            inboxButtonElement = $(xpath("//android.view.ViewGroup[@resource-id=\"net.papirus.androidclient:id/nd_tab_inbox\"]")),
            incorrectPasswordMessageElement = $(xpath("//android.widget.TextView[@resource-id=\"net.papirus.androidclient:id/textinput_error\"]")),
            incorrectLoginELement = $(AppiumBy.id("net.papirus.androidclient:id/textinput_error"));

    public MobilePage clickLogin() {
        buttonLoginElement.click();
        return this;
    }

    public MobilePage setEmail(String email) {
        emailFieldElement.sendKeys(email);
        return this;
    }

    public MobilePage clickNext() {
        nextButtonElement.click();
        return this;
    }

    public MobilePage clickTypePassword() {
        typePasswordButtonElement.click();
        return this;
    }

    public MobilePage setPassword(String password) {
        passwordFieldElement.sendKeys(password);
        return this;
    }

    public MobilePage clickNext2() {
        next2ButtonElement.click();
        return this;
    }

    public MobilePage clickNext3() {
        next3ButtonElement.click();
        return this;
    }

    public MobilePage checkThePageHasKnowledgeButton() {
        knowledgeButtonElement.should(exist);
        return this;
    }

    public MobilePage checkLoginIncorrectMessage(String text) {
        incorrectLoginELement.shouldHave(text(text + ": An email address must contain a single @ sign."));
        return this;
    }

    public MobilePage checkPasswordIncorrectMessage(String text) {
        incorrectPasswordMessageElement.shouldHave(text(text));
        return this;
    }
}