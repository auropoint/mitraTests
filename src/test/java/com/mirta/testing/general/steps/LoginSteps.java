package com.mirta.testing.general.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.mirta.testing.common.Tools;
import com.mirta.testing.general.pages.AllFilesPage;
import com.mirta.testing.general.pages.LoginPage;
import com.mirta.testing.general.pages.LeftSidebar;
import com.mirta.testing.general.pages.StartPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;

public class LoginSteps {

  @Step("Шаг - вход в систему внутренним пользователем, с логином {0} и паролем {1}")
  public void loginInternalUserWithUsernameAndPassword(String username, String password) throws InterruptedException {
    commonSteps.openStartPage();
    loginPage.loginInput.setValue(username);
    loginPage.passwordInput.setValue(password);
    loginPage.loginSubmitButton.click();
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.userProfileInfo.shouldBe(Condition.visible);
    Assertions.assertTrue(allFilesPage.userProfileInfo.isDisplayed());
  }



  @Step("Шаг - вход в систему внешним пользователем, с почтой {1} и отп")
  public void loginExternalUserWithEmailAndOtp(EmailSteps emailSteps, String email) throws InterruptedException {

    //get link
    Selenide.switchTo().window(1);
    String externalShareLink = emailSteps.getExternalShareLinkFromEmail();
    Selenide.switchTo().window(0);
    System.out.println("ExternalShareLink : " + externalShareLink);


    //open link, set email
    Selenide.open(externalShareLink);
    loginPage.externalLoginInput.setValue(email);
    Thread.sleep(1000);

//              Tools.openWebConsole();


    loginPage.loginSubmitButton.click();

//              Thread.sleep(120000);

    loginPage.otpInput.shouldBe(Condition.visible);
    Thread.sleep(1000);

    //get otp
    Selenide.switchTo().window(1);
    String otp = emailSteps.getOtpFromEmail();
    Selenide.switchTo().window(0);
    System.out.println("OTP : " + otp);

    //set otp
    loginPage.otpInput.setValue(otp);
    Thread.sleep(1000);
    loginPage.loginSubmitButton.click();

    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.userProfileInfo.shouldBe(Condition.visible);
    Assertions.assertTrue(allFilesPage.userProfileInfo.isDisplayed());
  }


  @Step("Шаг - разлогин из системы")
  public void logout() {
    commonSteps.openStartPage();
//    leftSidebar.avatarMenu.shouldBe(visible);
//    leftSidebar.avatarMenu.click();
    leftSidebar.logoutButton.click();
    loginPage.loginInput.shouldBe(visible);
  }

  CommonSteps commonSteps = new CommonSteps();
  StartPage startPage = new StartPage();
  LoginPage loginPage = new LoginPage();
  AllFilesPage allFilesPage = new AllFilesPage();
  LeftSidebar leftSidebar = new LeftSidebar();

}

