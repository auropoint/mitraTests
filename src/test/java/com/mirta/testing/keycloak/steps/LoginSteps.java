package com.mirta.testing.keycloak.steps;
import com.codeborne.selenide.Condition;
import com.mirta.testing.keycloak.pages.LeftSidebar;
import com.mirta.testing.keycloak.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class LoginSteps{

  @Step("Шаг - вход в систему с логином {0} и паролем {1}")
  public void loginWithUsernameAndPassword(String username, String password) {
    commonSteps.openLoginPage();
    loginPage.loginSubmitButton.shouldBe(Condition.visible);
    loginPage.loginInput.shouldBe(Condition.visible);
    loginPage.loginInput.setValue(username);
    loginPage.passwordInput.setValue(password);
    loginPage.loginSubmitButton.click();
    leftSidebar.realmSelector.shouldBe(Condition.visible);
    Assertions.assertTrue(leftSidebar.realmSelector.isDisplayed());
  }

  CommonSteps commonSteps = new CommonSteps();
  LeftSidebar leftSidebar = new LeftSidebar();
  LoginPage loginPage = new LoginPage();

}
