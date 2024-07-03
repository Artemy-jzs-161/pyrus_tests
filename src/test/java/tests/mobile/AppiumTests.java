package tests.mobile;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestData;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

public class AppiumTests extends TestBase {
    TestData data = new TestData();

    @Test
    @DisplayName("pyrus test")
    @Tag("emulator")
    void OnboardingScreenTest2() {
        step("Нажать на кнопку Log in", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/login_tv")).click();
        });
        step("Ввести Email address", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/lf_sp_email"))
                    .sendKeys(data.email);
        });
        step("Нажать на кнопку Next", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/al_next")).click();
        });
        step("Нажать на кнопку Type password", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/al_type_password"))
                    .click();
        });
        step("Ввести password", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/lf_ep_pass")).sendKeys(data.password);
        });
        step("Нажать на кнопку Next", () -> {
            $(xpath("(//android.widget.Button[@resource-id=\"net.papirus.androidclient:id/al_next\"])[2]\n")).click();
        });

        step("Нажать на кнопку Next", () -> {
            $(AppiumBy.id("net.papirus.androidclient:id/nd_tab_lists_image")).click();
        });

        step(".....", () -> {
            $(AppiumBy.id(" net.papirus.androidclient:id/title")).click();
        });





    }


}
