package com.mirta.testing.keycloak.tests;

import com.mirta.testing.core.FrameworkConfigurator;
import com.mirta.testing.keycloak.steps.CommonSteps;
import com.mirta.testing.keycloak.steps.LoginSteps;
import com.mirta.testing.keycloak.testData.KeycloakData;

//@Execution(ExecutionMode.CONCURRENT)

public class AutotestUserDeletionTest extends FrameworkConfigurator {
//  @Test
//  @DisplayName("Autotest User Deletion")
//  @Severity(SeverityLevel.BLOCKER)
  public void autotestUserDeleter() {
    commonSteps.openLoginPage();
    loginSteps.loginWithUsernameAndPassword(KeycloakData.username, KeycloakData.password);
    commonSteps.deleteAutotestUser();
  }

  CommonSteps commonSteps = new CommonSteps();
  LoginSteps loginSteps = new LoginSteps();

}
