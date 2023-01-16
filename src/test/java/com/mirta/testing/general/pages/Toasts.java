package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Toasts {


  public SelenideElement

          shareSuccess = $x("//div[contains(@class, 'fade toast toast-success show')]"),


  toastCloser = $x("//div[contains(@class, 'fade toast toast-success show')]/..//span[@aria-hidden='true']");

}