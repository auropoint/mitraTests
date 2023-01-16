package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement
            loginInput = $("input[name='login']"),
            passwordInput = $("input[name='password']"),
            loginSubmitButton = $x("//button[@type='submit']");

}
