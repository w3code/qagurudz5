package io.github.w3code.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest extends TestBase {
    Faker faker = new Faker();

    StudentData student = new StudentData(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.demographic().sex(),
            faker.phoneNumber().phoneNumber(),
            faker.number().numberBetween(1, 28),
            faker.number().numberBetween(0, 11),
            faker.number().numberBetween(1900, 2008),
            faker.number().numberBetween(0, 2),
            faker.address().fullAddress()
    );

    @Test
    void selenideFormTest() {
        registrationPage
                .openPage()
                .typeFirstName(student.firstName)
                .typeLastName(student.lastName)
                .typeEmail(student.email)
                .checkGender(student.gender)
                .typeMobile(student.mobile)
                .setDate(student.dayBirth, student.monthBirth, student.yearBirth)
                .typeSubject(student.subject)
                .checkHobby(student.hobby)
                .uploadPicture(student.picture)
                .typeAddress(student.currentAddress)
                .selectState(student.state)
                .selectCity(student.city)
                .submitData()
                .checkIsModalWindowOpened()
                .checkResultsValue("Student Name", student.firstName + ' ' + student.lastName)
                .checkResultsValue("Student Email", student.email)
                .checkResultsValue("Gender", student.gender)
                .checkResultsValue("Mobile", student.mobile)
                .checkResultsValue("Date of Birth", student.dateOfBirth())
                .checkResultsValue("Subjects", student.subject)
                .checkResultsValue("Hobbies", student.hobby)
                .checkResultsValue("Picture", student.picture)
                .checkResultsValue("Address", student.currentAddress)
                .checkResultsValue("State and City", student.state + " " + student.city)
                .closeModalWindow()
                .modalCloseCheck();
    }
}