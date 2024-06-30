package data.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainWebPage {
    private final SelenideElement
            avatarMenuOrgInfoElement = $(".avatarMenuOrgInfo_noOrgLogo"),
            newTaskButton = $(".primaryButtonWithDropdown__text"),
            titleFieldElement = $("trix-editor[aria-label='Заголовок новой задачи']"),
            taskDescriptionFieldElement = $("trix-editor[aria-label='Описание задачи']"),
            sendButton = $x("/html/body/div[6]/div/div/div[1]/div/div[2]/div[6]/div/button[1]/span"),
            settingButton = $("button[aria-label='Настройки'] svg[aria-hidden='true']"),
            linkPreferencesPage = $x("/html/body/div[5]/div[2]/div/div/ul[1]/li[2]/a"),
            checkNameTask = $("div[class='virtualList__itemsScroller']");


    public MainWebPage checkCompanyName(String companyName) {
        avatarMenuOrgInfoElement.shouldHave(text(companyName));
        return this;
    }

    public MainWebPage pressNewTask() {
        newTaskButton.click();
        return this;
    }

    public MainWebPage setTaskName(String taskName) {
        titleFieldElement.setValue(taskName);
        return this;
    }

    public MainWebPage setTaskDescription(String taskDescription) {
        taskDescriptionFieldElement.setValue(taskDescription);
        return this;
    }

    public MainWebPage creatTask() {
        sendButton.click();
        return this;
    }

    public MainWebPage clickSettingButton() {
        settingButton.click();
        return this;
    }

    public MainWebPage clickPreferencesButton() {
        linkPreferencesPage.click();
        return this;
    }


    public MainWebPage checkTaskName(String taskName) {
        checkNameTask.shouldHave(text(taskName));
        return this;
    }




}
