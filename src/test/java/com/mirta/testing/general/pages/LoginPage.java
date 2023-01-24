package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
  public SelenideElement

          // Internal user
          loginInput = $("input[name='login']"),
          passwordInput = $("input[name='password']"),
          loginSubmitButton = $x("//button[@type='submit']"),

          // External user
          externalLoginInput = $("input[name='email']"),
          otpInput = $("input[name='otp']");

}
