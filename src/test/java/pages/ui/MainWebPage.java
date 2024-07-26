package pages.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainWebPage {
    private final SelenideElement
            avatarMenuOrgInfoElement = $(".avatarMenuOrgInfo_noOrgLogo"),
            newTaskButton = $(".primaryButtonWithDropdown__text"),
            titleFieldElement = $("trix-editor[aria-label='Заголовок новой задачи']"),
            taskDescriptionFieldElement = $("trix-editor[aria-label='Описание задачи']"),
            sendButton = $("button[data-test-id='btnSaveTask'] span[data-test-id='ButtonContent']"),
            settingButton = $("button[aria-label='Настройки'] svg[aria-hidden='true']"),
            linkPreferencesPage = $(byText("Предпочтения")),
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
