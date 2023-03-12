package com.qa.pageobject.helper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qa.pageobject.config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;

import java.util.logging.Level;

public class DriverHelper {
    public static void configDriver (WebDriverConfig config){
        Configuration.browser = config.getBrowser();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.holdBrowserOpen = config.getHoldBrowserOpen();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .enableLogs(LogType.BROWSER, Level.ALL)
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true));
    }
}
