package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContextMenu {

  public SelenideElement

          viewAsXlsx = $x("//div[@class='react-contexify__item']//*[text()='View as XLSX']"),
          viewAsPdf = $x("//div[@class='react-contexify__item']//*[text()='Open']"),
          downloadFileOrFolderAsArchive = $x("//div[@class='react-contexify__item']//*[contains(text(), 'Download')]"),
          rename = $x("//div[@class='react-contexify__item']//*[text()='Rename']");



}
