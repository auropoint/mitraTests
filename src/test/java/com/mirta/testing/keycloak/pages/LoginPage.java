package com.mirta.testing.keycloak.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
  public SelenideElement
          loginInput = $x("//input[@id='username']"),
          passwordInput = $x("//input[@id='password']"),
          loginSubmitButton = $x("//input[@id='kc-login']");



}
