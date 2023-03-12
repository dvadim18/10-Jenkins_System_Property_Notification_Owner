package com.qa.pageobject.tests;

import com.codeborne.selenide.Selenide;
import com.qa.pageobject.config.WebDriverConfig;
import com.qa.pageobject.pages.StepsRegistrationPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

import static com.qa.pageobject.helper.DriverHelper.configDriver;

public class TestBase {
    StepsRegistrationPage stepsRegistrationPage = new StepsRegistrationPage();
    private static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    @BeforeAll
    @Tag("TestBaseCFG")
    static void beforeAll() {
        configDriver(config);

    }

    @AfterEach
    void addAttachments() {
        AttachmentExtension.attachScreenshot();
        AttachmentExtension.pageSource();
        Selenide.closeWebDriver();


    }
}
