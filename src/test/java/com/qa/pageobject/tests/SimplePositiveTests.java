package com.qa.pageobject.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Suit Name - simplePositiveTests")

public class SimplePositiveTests {

    @BeforeAll

    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Test
    @Tag("Smoke")
    void test() {
        assertTrue(false);
    }

    @Test
    @Tag("RC")
    void test1() {
        assertTrue(true);
    }

    @Test
    @Tag("Smoke")
    void test2() {
        assertTrue(true);
    }

    @Test
    @Tag("RC")
    void test3() {
        assertTrue(false);
    }
}
