package com.mirta.testing.general.steps;

import com.codeborne.selenide.Selenide;
import com.mirta.testing.core.TempMailHandler;
import com.mirta.testing.general.pages.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EmailSteps {

  TempMailHandler tempMailHandler = new TempMailHandler();
  EmailPages emailPages = new EmailPages();


  @Step("Шаг - создание адреса почты и копирование его в буфер обмена")
  public String getNewEmailAddress(String emailName) throws InterruptedException {
    return tempMailHandler.createEmailAddress(emailName);
  }

  @Step("Шаг - взятие ссылки на публикацию из почты")
  public String getExternalShareLinkFromEmail() {
    tempMailHandler.waitAndOpenEmail( 120000L);
    String externalShareLink = emailPages.shareLinkElement.getAttribute("href");
    tempMailHandler.exitEmail();
    return externalShareLink;
  }

  @Step("Шаг - взятие ОТП из почты")
  public String getOtpFromEmail() throws InterruptedException {
    tempMailHandler.waitAndOpenEmail(120000L);
//    Thread.sleep(120000);
    String otpContainer = emailPages.otpEmailString.getText();
    tempMailHandler.exitEmail();
    return otpContainer.substring(otpContainer.indexOf(':') + 2);
  }

  @Step("Шаг - взятие пароля для открытия ПДФ из почты")
  public String getPdfViewPasswordFromEmail() {
    tempMailHandler.waitAndOpenEmail(120000L);
    String otpContainer = emailPages.pdfViewPasswordEmailString.getText();
    return otpContainer.substring(otpContainer.indexOf(':') + 2);
  }


}
