package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContextMenu {

  public SelenideElement

          viewAsXlsx = $x("//div[@class='react-contexify__item'][2]"),
          downloadFolderAsArchive = $x("//div[@class='react-contexify__item'][2]"),
          rename = $x("//div[@class='react-contexify__item'][5]");



}
