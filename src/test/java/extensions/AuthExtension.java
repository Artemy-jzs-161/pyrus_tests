package extensions;

import groovy.transform.stc.POJO;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import api.AuthorizationApi;
import models.authorization.AuthRequestModel;
import models.authorization.AuthResponseModel;
import tests.api.TestData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

//TODO
public class AuthExtension implements BeforeEachCallback {
    @Override
    @Step("Войдите в систему и установите файлы cookie")
    public void beforeEach(ExtensionContext context) throws Exception {
        AuthorizationApi api = new AuthorizationApi();
        AuthRequestModel authRequestModel = new AuthRequestModel(TestData.USERNAME, TestData.PASSWORD);
        AuthResponseModel authResponseModel = new AuthResponseModel(authRequestModel);

        //TODO
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("access_token", authResponseModel.getAccess_token()));
       //getWebDriver().manage().addCookie(new Cookie("token", authResponseModel.getApi_url()));
       //getWebDriver().manage().addCookie(new Cookie("expires", authResponseModel.getFiles_url()));
    }

    }
