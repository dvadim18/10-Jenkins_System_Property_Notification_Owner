package com.qa.pageobject.tests;

import com.qa.pageobject.testdata.UserData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Suit Name - Fill Form Student Registration Form")
public class FillFormAnnotatedSteps extends TestBase {

    @Test
    @Tags({@Tag("TestBaseCFG"), @Tag("FillFormAnnotatedSteps")})
    @Feature("Demo Practice Form - Student Registration Form")
    @Story("Заполнение формы \"Student Registration Form\"")
    @Owner("V.Dinislamov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Student Registration Form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Тест формы Student Registration Form")
    void studentRegistrationForm() {

        UserData userData = new UserData();


        stepsRegistrationPage.openPage()
                .setFirstName(userData.firsName)
                .setLastName(userData.lastName)
                .setEmail(userData.Email)
                .setGender (userData.Gender)
                .setPhone(userData.Phone)
                .setBirthDayDate(userData.getBirthday())
                .autocompleteForm(userData.Subjects)
                .setHobbies(userData.Hobbies)
                .fileUploadForm(userData.Picture)
                .setTextArea(userData.CurrentAddress)
                .setStateDropDownMenu(userData.State)
                .setCityDropDownMenu(userData.City)
                .submitPracticeForm()

                //Modal windoW
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userData.firsName + " " + userData.lastName)
                .verifyResult("Student Email", userData.Email)
                .verifyResult("Gender", userData.Gender)
                .verifyResult("Mobile", userData.Phone)
                .verifyResult("Date of Birth", userData.getBirthday())
                .verifyResult("Subjects", userData.Subjects)
                .verifyResult("Hobbies", userData.Hobbies)
                .verifyResult("Picture", userData.Picture.substring(4))
                .verifyResult("Address", userData.CurrentAddress)
                .verifyResult("State and City", userData.State+" " +userData.City)
                .verifyModalResultSubmit();


    }
}
