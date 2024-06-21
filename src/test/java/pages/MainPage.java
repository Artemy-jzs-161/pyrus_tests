package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement
            avatarMenuOrgInfoElement = $(".avatarMenuOrgInfo_noOrgLogo"),
            newTaskButton = $(".primaryButtonWithDropdown__text"),
            titleFieldElement = $("trix-editor[aria-label='Заголовок новой задачи']"),
            taskDescriptionFieldElement = $("trix-editor[aria-label='Описание задачи']"),
            sendButton = $x("/html/body/div[6]/div/div/div[1]/div/div[2]/div[6]/div/button[1]/span");

    public MainPage checkCompanyName(String companyName) {
        avatarMenuOrgInfoElement.shouldHave(text(companyName));
        ;
        return this;
    }

    public MainPage pressNewTask() {
        newTaskButton.click();
        return this;
    }

    public MainPage setTaskName(String taskName) {
        titleFieldElement.setValue(taskName);
        return this;
    }

    public MainPage setTaskDescription(String taskDescription) {
        taskDescriptionFieldElement.setValue(taskDescription);
        return this;
    }

    public MainPage creatTask() {
        sendButton.click();
        return this;
    }




}
