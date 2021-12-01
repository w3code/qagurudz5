package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.config.CredentialsConfig;
import io.github.w3code.helpers.Attach;
import io.github.w3code.pages.RegistrationPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void startMaximized() {
        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);
        String login = credentials.login();
        String password = credentials.password();

        String selenoid_url = System.getProperty("selenoid_url", "url");

        Configuration.browserSize = "1920x1080";
        Configuration.remote = format("https://%s:%s@" + selenoid_url, login, password);

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
