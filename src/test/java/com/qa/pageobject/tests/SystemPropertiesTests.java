package com.qa.pageobject.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


@DisplayName("Suit Name - SystemPropertiesTests")
public class SystemPropertiesTests {

    @Test
    void simplePropertiesTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertiesTest1() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertiesTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("system_properties")
    @DisplayName("Тест передачи данных через System.setProperty")
    void simplePropertiesTest3() {
        System.setProperty("browser", "chrome");// передача значений из "вне"
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);

        //gradle clean test
        //gradle clean system_properties
        //gradle clean system_properties -Dbrowser=chrome

    }

    @Test
    @Tags({@Tag("TestBaseCFG"), @Tag("system_properties_student_name")})
    @DisplayName("Student Name")
    void simplePropertiesTest4() {

        String browserName = System.getProperty("user_name", "unknown student");
        System.out.println(browserName);

    }
    //gradle clean system_properties_student_name -Duser_name=Vadim
    //Vadim

    //gradle clean system_properties_student_name -Duser_name=Vadim Dinislamov
    //FAILURE: Build failed with an exception.
    //
    //* What went wrong:
    //Task 'Dinislamov' not found in root project 'QA_GURU_10-Jenkins_System_Property'.

    //gradle clean system_properties_student_name "-Duser_name=Vadim Dinislamov" // для передачи значений ключа содержащих пробелы, необходимо использовать кавычки
    //gradle clean system_properties_student_name -Duser_name="Vadim Dinislamov"


}
