package data.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BlogWebPage {

    private final SelenideElement

            inputFieldSearch = $(".field"),
            noResultMessage = $(".page-content"),
            postElement = $x("//h2[@class='entry-title']");




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
