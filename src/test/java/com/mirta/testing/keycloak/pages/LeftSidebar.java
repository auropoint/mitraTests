package com.mirta.testing.keycloak.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LeftSidebar {

    public SelenideElement
            usersButton = $x("//div[@kc-sidebar-resize]//a[contains(text(), 'Users')]"),
            realmSelector = $x ("//div[@class='realm-selector']");

}
