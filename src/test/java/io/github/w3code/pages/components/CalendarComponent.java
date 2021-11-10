package io.github.w3code.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private SelenideElement
            dateInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    private ElementsCollection
            dayInput = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        dateInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        dayInput.filter(text(day)).first().click();
    }
}
