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
    String subject;
    String hobby;
    String picture;
    String currentAddress;
    String state;
    String city;
    String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] hobbies = new String[]{"Sports", "Reading", "Music"};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile.replaceAll("\\D", "").substring(0, 10);
    }

    public String getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = String.valueOf(dayBirth);
    }

    public String getMonthBirth() {
        return monthBirth;
    }

    public void setMonthBirth(int monthBirth) {
        this.monthBirth = months[monthBirth];
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = String.valueOf(yearBirth);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(int hobbyNum) {
        this.hobby = hobbies[hobbyNum];
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //Создаем метод добавления нуля к числу рождения, если оно однозначное. Используется в валидации.

    public String getBirthDate() {
        if (dayBirth.length() == 1) {
            return '0' + dayBirth + ' ' + monthBirth + ',' + yearBirth;
        }
        return dayBirth + ' ' + monthBirth + ',' + yearBirth;
    }

    StudentData(String firstName, String lastName, String email, String gender, String mobile, int dayBirth, int monthBirth, int yearBirth, String subject, int hobbyNum, String picture, String currentAddress, String state, String city) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setGender(gender);
        setMobile(mobile);
        setDayBirth(dayBirth);
        setMonthBirth(monthBirth);
        setYearBirth(yearBirth);
        setSubject(subject);
        setHobby(hobbyNum);
        setPicture(picture);
        setCurrentAddress(currentAddress);
        setState(state);
        setCity(city);
    }
}
