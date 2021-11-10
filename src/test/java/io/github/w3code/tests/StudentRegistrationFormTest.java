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
            "Accounting",
            faker.number().numberBetween(0, 2),
            "test.jpg",
            faker.address().fullAddress(),
            "NCR",
            "Delhi"
    );

    @Test
    void selenideFormTest() {
        registrationPage
                .openPage()
                .typeFirstName(student.getFirstName())
                .typeLastName(student.getLastName())
                .typeEmail(student.getEmail())
                .checkGender(student.getGender())
                .typeMobile(student.getMobile())
                .setDate(student.getDayBirth(), student.getMonthBirth(), student.getYearBirth())
                .typeSubject(student.getSubject())
                .checkHobby(student.getHobby())
                .uploadPicture(student.getPicture())
                .typeAddress(student.getCurrentAddress())
                .selectState(student.getState())
                .selectCity(student.getCity())
                .submitData()
                .checkIsModalWindowOpened()
                .checkResultsValue("Student Name", student.getFirstName() + ' ' + student.getLastName())
                .checkResultsValue("Student Email", student.getEmail())
                .checkResultsValue("Gender", student.getGender())
                .checkResultsValue("Mobile", student.getMobile())
                .checkResultsValue("Date of Birth", student.getDateOfBirth())
                .checkResultsValue("Subjects", student.getSubject())
                .checkResultsValue("Hobbies", student.getHobby())
                .checkResultsValue("Picture", student.getPicture())
                .checkResultsValue("Address", student.getCurrentAddress())
                .checkResultsValue("State and City", student.getState() + " " + student.getCity())
                .closeModalWindow()
                .modalCloseCheck();
    }
}