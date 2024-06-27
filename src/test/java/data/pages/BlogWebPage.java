package data.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BlogWebPage {

    private final SelenideElement

            inputFieldSearch = $(".field"),
            noResultMessage = $x("/html/body/div[2]/div/div/section/main/section/div/p[1]"),
            postElement = $x("/html/body/div[2]/div/div/section/main/div[2]/article[1]/a/header/h2");


    public BlogWebPage searchInfo(String info) {
        inputFieldSearch.setValue(info).pressEnter();
        return this;
    }

    public BlogWebPage checkSearchInfo(String info) {
        postElement.shouldHave(text(info));
        return this;
    }

    public BlogWebPage checkNulLResultMessage(String info) {
        noResultMessage.shouldHave(text(info));
        return this;
    }
}
