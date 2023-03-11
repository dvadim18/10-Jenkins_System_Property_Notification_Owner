package com.qa.pageobject.pages;

import com.qa.pageobject.tests.AttachmentExtension;
import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import com.qa.pageobject.pages.components.Calendar;
import com.qa.pageobject.pages.components.FileUpload;
import com.qa.pageobject.pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StepsRegistrationPage {

    AttachmentExtension attachmentExtension = new AttachmentExtension();
    Calendar calendar = new Calendar();

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    FileUpload fileUpload = new FileUpload();
    private final String TITLE_TEXT = "Student registration Form";
    private SelenideElement
            lastNameInput = $x("//div[@id='userName-wrapper']//input[@id='lastName']"),
            firstNameInput = $("#firstName"),
            emailInput = $x("//div[@id='userEmail-wrapper']//input[@id='userEmail']"),
            setPhone = $x("//div[@id='userNumber-wrapper']//input[@id='userNumber']");


    @Step("Открываем страницу на форму ввода")
    public StepsRegistrationPage openPage() {
        open("/automation-practice-form"); // relative link
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        //attachment("Source", webdriver().driver().source());
        attachmentExtension.attachScreenshot();


        return this;
    }

    @Step("Заполняем поле ввода FirstName")
    public StepsRegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        attachmentExtension.attachScreenshot();
//        attachmentExtension.pageSource();
//        attachmentExtension.browserConsoleLogs();
//        attachmentExtension.getVideoUrl();


        return this;
    }


    @Step("Заполняем поле ввода LastName")
    public StepsRegistrationPage setLastName(String value) {
        lastNameInput.clear();
        lastNameInput.setValue(value);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Заполняем поле ввода Email")
    public StepsRegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Выбираем радиобаттон Gender")
    public StepsRegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Заполняем поле ввода Mobile")
    public StepsRegistrationPage setPhone(String value) {
        setPhone.setValue(value);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Заполняем календарь Date of Birth")
    public StepsRegistrationPage setBirthDayDate(String birthday) {
        $("#dateOfBirthInput").click();
        calendar.setDate(birthday);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Заполняем  автокомплит-форму Subjects")
    public StepsRegistrationPage autocompleteForm(String value) {
        $x("//*[@id='subjectsInput']").click();
        $x("//*[@id='subjectsInput']").sendKeys(value);
        $x("//*[@id='subjectsInput']").pressTab();
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Отмечаем чек-боксы Hobbies")
    public StepsRegistrationPage setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Загружаем изображение по кнопке \"Выберите файл\"")
    public StepsRegistrationPage fileUploadForm(String value) {
        fileUpload.anyfileUpload(value);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Заполняем не строгую форму ввода адреса Current Address")
    public StepsRegistrationPage setTextArea(String value) {
        $x("//textarea[@id='currentAddress']").setValue(value);
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Выбираем из дроп-даун меню State")
    public StepsRegistrationPage setStateDropDownMenu(String value) {
        $x("//div[@id ='stateCity-wrapper']//div[@id= 'state']").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        attachmentExtension.attachScreenshot();
        return this;
    }

    @Step("Выбираем из дроп-даун меню City")
    public StepsRegistrationPage setCityDropDownMenu(String value) {
        $x("//input[@id = 'react-select-4-input']").setValue(value).pressTab();
        attachmentExtension.attachScreenshot();
        return this;
    }

    @Step("Подтверждаем форму на кнопку \"Submit\"")
    public StepsRegistrationPage submitPracticeForm() {
        $x("//button[@id = 'submit']").click();
        attachmentExtension.attachScreenshot();
        return this;
    }

    @Step("Тест появления модального окна")
    public StepsRegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        attachmentExtension.attachScreenshot();

        return this;
    }

    @Step("Тест соответствия веденых данных полям таблицы {key} {value}")
    public StepsRegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        attachmentExtension.attachScreenshot();

        return this;
    }
    @Step("Тест подтверждения модального окна на кнопку \"Close\"")
    public StepsRegistrationPage verifyModalResultSubmit() {
        registrationResultsModal.verifyResultSubmit();
        attachmentExtension.attachScreenshot();

        return this;
    }

}
