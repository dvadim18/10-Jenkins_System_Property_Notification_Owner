package com.qa.pageobject.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:browser.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("holdBrowserOpen")
    @DefaultValue("true")
    Boolean getHoldBrowserOpen();

}
