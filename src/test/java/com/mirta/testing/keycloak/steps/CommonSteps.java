package com.mirta.testing.keycloak.steps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.mirta.testing.keycloak.pages.UsersPage;
import com.mirta.testing.keycloak.pages.LeftSidebar;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class CommonSteps {

  @Step("Шаг - открытие страницы логина")
  public void openLoginPage() {
    Selenide.open("https://qa.passport.aitusauda.kz/auth/admin/master/console/");
  }

  @Step("Шаг - удаление юзера, созданного автотестом")
  // по факту удаляется первый попавшийся автотест-юзер
  public void deleteAutotestUser() {
    leftSidebar.usersButton.click();
    usersPage.viewAllUsersButton.click();
    usersPage.usersTableHeader.shouldBe(Condition.visible);

// блок пагинации юзеров для поиска первого попавшегося автотест-юзера, если он не нашёлся на 1-й странице
    int i = 0;
    while (i < 100) {

      if (usersPage.autotestUserDeleteButton.is(Condition.visible)) {
        usersPage.autotestUserDeleteButton.click();
        usersPage.userDeleteConfirmationButton.click();
        usersPage.userDeletedSuccessNote.shouldBe(Condition.visible);
        usersPage.usersTableHeader.shouldBe(Condition.visible);
        break;
      } else {
        usersPage.userNextPageButton.click();
        usersPage.usersTableHeader.shouldBe(Condition.visible);
        i++;
      }
    }

    Assertions.assertTrue(usersPage.userDeletedSuccessNote.isDisplayed());



  }

  LeftSidebar leftSidebar = new LeftSidebar();
  UsersPage usersPage = new UsersPage();

}
