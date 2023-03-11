package com.qa.pageobject.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qa.pageobject.pages.StepsRegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

import java.util.logging.Level;

public class TestBase {
    StepsRegistrationPage stepsRegistrationPage = new StepsRegistrationPage();

    @BeforeAll
    @Tag("TestBaseCFG")
    static void beforeAll() {



        Configuration.headless = false;

        Configuration.holdBrowserOpen = false;

        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        //Configuration.browserSize = "1920x1080";

        Configuration.baseUrl = System.getProperty("baseURL", "https://demoqa.com");
        //Configuration.baseUrl = "https://demoqa.com";

        Configuration.browser = System.getProperty("browser", "chrome");
       // Configuration.browser = "chrome";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                //.enableLogs(LogType.CLIENT, Level.ALL)
                .enableLogs(LogType.BROWSER, Level.ALL)
                //.enableLogs(LogType.DRIVER, Level.ALL)
                // .enableLogs(LogType.PERFORMANCE, Level.ALL)
                //.enableLogs(LogType.PROFILER, Level.ALL)
                // .enableLogs(LogType.SERVER, Level.ALL)
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true));

//Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //ссылка на удаленный хост где установлен браузер(хнутри селеноида выбрана уже версия браузера)
// для записи видео в селеноиде
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;


    }

    @AfterEach
    void addAttachments (){
        AttachmentExtension.attachScreenshot();
        AttachmentExtension.pageSource();

        //AttachmentExtension.browserConsoleLogs();
        //AttachmentExtension.addVideo();  //String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        Selenide.closeWebDriver();




    }
}
