package io.github.w3code.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.github.w3code.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import java.util.Map;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage {
    //locators and elements
    private final String FORM_TITLE = "Student Registration Form";
    private final String MODAL_TITLE = "Thanks for submitting the form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            emailInput = $("#userEmail"),
            mobileInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            userPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            closeButton = $("#closeLargeModal"),
            bodyElement = $(byTagName("body"));

    public ElementsCollection
            userGender = $$x("//label[starts-with(@for, 'gender-radio')]"),
            userHobby = $$x("//label[starts-with(@for, 'hobbies-checkbox')]"),
            resultLines = $$(".table-responsive tbody tr");

    //actions
    @Step("Open the registration form page")
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Type first name")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Type last name")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Type email")
    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Check gender radio button")
    public RegistrationPage checkGender(String value) {
        userGender.findBy(text(value)).click();
        return this;
    }

    @Step("Type mobile")
    public RegistrationPage typeMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    @Step("Set birth date")
    public RegistrationPage setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    @Step("Type subject")
    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Check hobby radio button")
    public RegistrationPage checkHobby(String value) {
        userHobby.findBy(text(value)).click();
        return this;
    }

    @Step("Upload student's photo")
    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath("img/" + value);
        return this;
    }

    @Step("Type address")
    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Select state")
    public RegistrationPage selectState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step("Select city")
    public RegistrationPage selectCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    @Step("Click submit button")
    public RegistrationPage submitData() {
        submitButton.pressEnter();
        return this;
    }

    @Step("Check is modal window opened")
    public RegistrationPage checkIsModalWindowOpened() {
        modalTitle.shouldHave(text(MODAL_TITLE));
        return this;
    }

    @Step("Check result values")
    public RegistrationPage checkResultsValue(Map expectedData) {
        ElementsCollection lines = resultLines.snapshot();
        for (SelenideElement line : lines) {
            String key = line.$("td").text();
            String actualValue = line.$("td", 1).text();
            assertEquals(expectedData.get(key), actualValue, "message");
        }
        return this;
    }

    @Step("Close modal window")
    public RegistrationPage closeModalWindow() {
        closeButton.click();
        return this;
    }

    @Step("Check is modal window closed")
    public void modalCloseCheck() {
        bodyElement.shouldNotHave(cssClass("modal-open"));
    }
}
