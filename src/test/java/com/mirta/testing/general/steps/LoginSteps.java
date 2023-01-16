package com.mirta.testing.general.steps;

import com.codeborne.selenide.Condition;
import com.mirta.testing.general.pages.AllFilesPage;
import com.mirta.testing.general.pages.LoginPage;
import com.mirta.testing.general.pages.LeftSidebar;
import com.mirta.testing.general.pages.StartPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;

public class LoginSteps {

  @Step("Шаг - вход в систему с логином {0} и паролем {1}")
  public void loginWithUsernameAndPassword(String username, String password) {
    commonSteps.openStartPage();
    loginPage.loginInput.setValue(username);
    loginPage.passwordInput.setValue(password);
    loginPage.loginSubmitButton.click();
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));
    allFilesPage.initFolderCreationButton.shouldBe(Condition.visible);
    Assertions.assertTrue(allFilesPage.initFolderCreationButton.isDisplayed());
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

