package pages;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class GreetingWebPage {
    private final SelenideElement
            loginButtonElement = $("a[data-ga-event='login|go-to-pyrus|from-header']");


    public GreetingWebPage openPage(String domain) {
        open(domain);
        return this;
    }

    public GreetingWebPage pressLoginButton() {
        loginButtonElement.click();
        return this;
    }


}
