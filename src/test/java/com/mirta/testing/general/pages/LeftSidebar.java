package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LeftSidebar {

  public SelenideElement
          allFilesButton = $x("//div[@class='icon icon-folder']"),
          trashButton = $x("//div[@class='icon icon-trash']"),
          logoutButton = $x("//div[@class='icon icon-ext-exit']");



}
