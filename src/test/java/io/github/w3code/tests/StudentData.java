package io.github.w3code.tests;

public class StudentData {
    String firstName;
    String lastName;
    String email;
    String gender;
    String mobile;
    String dayBirth;
    String monthBirth;
    String yearBirth;
    String subject = "Accounting";
    String hobby;
    String picture = "test.jpg";
    String currentAddress;
    String state = "NCR";
    String city = "Delhi";

    String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] hobbies = new String[] {"Sports", "Reading", "Music"};

    StudentData(String firstName, String lastName, String email, String gender, String mobile, int dayBirth, int monthBirth, int yearBirth, int hobbyNum, String currentAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile.replaceAll("\\D","").substring(0, 10);
        this.dayBirth = String.valueOf(dayBirth);
        this.monthBirth = months[monthBirth];
        this.yearBirth = String.valueOf(yearBirth);
        this.hobby = hobbies[hobbyNum];
        this.currentAddress = currentAddress;

    }

    //Создаем метод добавления нуля к числу рождения, если оно однозначное. Используется в валидации.
    public String dateOfBirth() {
        if (dayBirth.length() == 1) {
            dayBirth = '0' + dayBirth;
        }
        return dayBirth + ' ' + monthBirth + ',' + yearBirth;
    }
}
