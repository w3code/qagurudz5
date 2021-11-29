package io.github.w3code.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    Map<String, String> expectedData = new HashMap<String, String>() {{
        put("Student Name", student.getFirstName() + ' ' + student.getLastName());
        put("Student Email", student.getEmail());
        put("Gender", student.getGender());
        put("Mobile", student.getMobile());
        put("Date of Birth", student.getBirthDate());
        put("Subjects", student.getSubject());
        put("Hobbies", student.getHobby());
        put("Picture", student.getPicture());
        put("Address", student.getCurrentAddress());
        put("State and City", student.getState() + " " + student.getCity());
    }};

    @Test
    @DisplayName("Student registration form test")
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
                .checkResultsValue(expectedData)
                .closeModalWindow()
                .modalCloseCheck();
    }
}