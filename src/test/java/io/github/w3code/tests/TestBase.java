package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.helpers.Attach;
import io.github.w3code.pages.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void startMaximized() {
        String selenoid_url = System.getProperty("selenoid_url", "url");

        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@" + selenoid_url;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
