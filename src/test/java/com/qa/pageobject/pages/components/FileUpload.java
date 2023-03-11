package com.qa.pageobject.pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class FileUpload {

    public void anyfileUpload(String value) {

        $x("//input[@id ='uploadPicture']").uploadFromClasspath(value);

    }
}
