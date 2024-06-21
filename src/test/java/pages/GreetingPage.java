package pages;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class GreetingPage {
    private final SelenideElement
            loginButtonElement = $("a[data-ga-event='login|go-to-pyrus|from-header']");


    public GreetingPage openPage(String domain) {
        open(domain);
        return this;
    }

    public GreetingPage pressLoginButton() {
        loginButtonElement.click();
        return this;
    }


}
