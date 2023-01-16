package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Viewers {



  public SelenideElement

          xlsxViewer = $x("//div[@class='x-spreadsheet-overlayer']"),
          xlsxViewerCloser = $x("//div[@class='modal-header']/..//span[text()='×']");




  public SelenideElement xlsxViewerFileNameInHeader(String fileName) {
    return  $x(String.format("//div[@class='modal-header']//div[contains(text(), '%s')]", fileName));
  }




}
