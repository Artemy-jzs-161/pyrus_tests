package data.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.*;
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
            moreButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_tab_more")),
            logOutButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_options_signout")),
            yesButtonElement = $(AppiumBy.id("android:id/button1")),
            plusButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_expanded_fab_item_fab")),
            newTaskElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_expanded_fab_item_tv")),
            taskNameFieldElement = $(AppiumBy.id("net.papirus.androidclient:id/taskTitleEditText")),
            taskDescriptionFieldElement = $(AppiumBy.id("net.papirus.androidclient:id/taskDescriptionEditText")),
            sendButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/sendButton")),
            knowledgeButtonElement = $(AppiumBy.id("net.papirus.androidclient:id/nd_tab_knowledge_base")),
            infoTextElement = $(AppiumBy.id("net.papirus.androidclient:id/fsp_text")),
            taskElement = $(xpath("(//android.view.ViewGroup[@resource-id=\"net.papirus.androidclient:id/clTask\"])[1]"));

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

    public MobilePage clickMore() {
        moreButtonElement.click();
        return this;
    }

    public MobilePage clickLogOut() {
        logOutButtonElement.click();
        return this;
    }

    public MobilePage clickYes() {
        yesButtonElement.click();
        return this;
    }

    public MobilePage clickPlusButton() {
        plusButtonElement.click();
        return this;
    }

    public MobilePage clickNewTask() {
        newTaskElement.click();
        return this;
    }

    public MobilePage setTaskName(String name) {
        taskNameFieldElement.sendKeys(name);
        return this;
    }

    public MobilePage setTaskDescription(String description) {
        taskDescriptionFieldElement.sendKeys(description);
        return this;
    }

    public MobilePage clickSend() {
        sendButtonElement.click();
        return this;
    }

    public MobilePage checkThePageHasKnowledgeButton() {
        knowledgeButtonElement.should(exist);;
        return this;
    }

    public MobilePage checkThePageHasLogInButton() {
        buttonLoginElement.should(exist);;
        return this;
    }

    public MobilePage checkInfoText(String text) {
        infoTextElement.shouldHave(text(text));
        return this;
    }

    public MobilePage checkCreationTask(String text) {
        taskElement.shouldHave(text(text));
        return this;
    }


}



