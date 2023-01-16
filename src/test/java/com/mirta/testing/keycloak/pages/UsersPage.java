package com.mirta.testing.keycloak.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class UsersPage {

    public SelenideElement
            viewAllUsersButton = $x("//button[@id='viewAllUsers']"),
            usersTableHeader = $x("//tr[@data-ng-show='searchLoaded && users.length > 0']"),
            autotestUserDeleteButton = $x("(//*[contains(text(), 'autotest')])[1]/../td[@data-ng-click='removeUser(user)']"),
            userDeleteConfirmationButton = $x("//button[@data-ng-class='btns.ok.cssClass']"),
            userDeletedSuccessNote = $x("//strong[contains(text(), 'Success')]"),
            userNextPageButton = $x("//button[@data-ng-click='nextPage()']");


}
