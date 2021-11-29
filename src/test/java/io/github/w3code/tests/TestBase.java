package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void startMaximized() {
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoide.autotests.cloud/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }
}
