package io.github.w3code.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.github.w3code.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

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
            userGender = $$(".custom-control-label"),
            userHobby = $$(".custom-control-label");

    //public static CalendarComponent calendar = new CalendarComponent();

    //actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage checkGender(String value) {
        userGender.findBy(text(value)).click();
        return this;
    }

    public RegistrationPage typeMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage checkHobby(String value) {
        userHobby.findBy(text(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath("img/" + value);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitData() {
        submitButton.pressEnter();
        return this;
    }

    public RegistrationPage checkIsModalWindowOpened() {
        modalTitle.shouldHave(text(MODAL_TITLE));
        return this;
    }


    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage closeModalWindow() {
        closeButton.click();
        return this;
    }

    public void modalCloseCheck() {
        bodyElement.shouldNotHave(cssClass("modal-open"));
    }


}
