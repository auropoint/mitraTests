package com.mirta.testing.keycloak.tests;


import com.mirta.testing.core.FrameworkConfigurator;
import com.mirta.testing.keycloak.steps.CommonSteps;
import com.mirta.testing.keycloak.steps.LoginSteps;
import com.mirta.testing.keycloak.testData.KeycloakData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@Execution(ExecutionMode.CONCURRENT)

public class LoginTest extends FrameworkConfigurator {
//  @Test
//  @DisplayName("Keycloak login")
//  @Severity(SeverityLevel.NORMAL)
  public void loginTest() {
    commonSteps.openLoginPage();
    loginSteps.loginWithUsernameAndPassword(KeycloakData.username, KeycloakData.password);

  }

  CommonSteps commonSteps = new CommonSteps();
  LoginSteps loginSteps = new LoginSteps();
}
