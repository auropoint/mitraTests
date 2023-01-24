package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Viewers {



  public SelenideElement

          fileOpenedInTableViewer = $x("//div[@class='x-spreadsheet-overlayer']"),
          fileDocumentLoaderInPdfViewer = $x("//div[@id='loadingDiv']"),
          filePageLoaderInPdfViewer = $x("//div[@class='loadingIcon']"),
          fileOpenedInPdfViewer = $("canvas[id='page1']"),


          viewersCloser = $x("//div[@class='modal-header']/..//span[text()='×']");




  public SelenideElement viewersFileNameInHeader(String fileName) {
    return  $x(String.format("//div[@class='modal-header']//div[contains(text(), '%s')]", fileName));
  }




}
