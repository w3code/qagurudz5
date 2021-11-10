package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void startMaximized() {
        Configuration.startMaximized = true;
    }


}
