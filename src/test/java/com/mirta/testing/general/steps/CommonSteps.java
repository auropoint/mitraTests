package com.mirta.testing.general.steps;

import com.codeborne.selenide.*;
import com.mirta.testing.general.pages.AllFilesPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.actions;

public class CommonSteps {

  public void openStartPage() {


    // Proxy server for selenide for files/folders downloads
    // by default it goes to /build/downloads; it can be specified below
    //    Configuration.downloadsFolder = "/src/downloads";
    Configuration.fileDownload = FileDownloadMode.PROXY;
    Configuration.proxyEnabled = true;

// deleting previous tests folders
    try {
      FileUtils.deleteDirectory(new File("build/downloads"));
      FileUtils.deleteDirectory(new File("build/reports/tests"));
    }
    catch (IOException e) {
      System.out.println("Folders do not exist or cannot be deleted to clean up before testing.");
    }


    Selenide.open("https://quality.vaulterix.ru/login");
//    Selenide.open("https://vdr.vaulterix.ru/login");
  }




  public void selectByCheckbox(String itemName) {
    if (!allFilesPage.itemSelctedCheckbox(itemName).exists()) {
      allFilesPage.item(itemName).click(ClickOptions.usingDefaultMethod());
    }
  }


  public void select(SelenideElement itemElement) {
    itemElement.click();
  }


  public void rightClick(String itemName) throws InterruptedException {
    allFilesPage.item(itemName).hover();
    actions().contextClick(allFilesPage.item(itemName)).build().perform();
    Thread.sleep(1000);
  }


  public boolean isItemPresent(SelenideElement element) {
    boolean b = false;
    try {
      if (element.isDisplayed()) {
        b = true;
      }
    } catch (NoSuchElementException e) {
      b = false;
    }
    return b;
  }

  AllFilesPage allFilesPage = new AllFilesPage();





}
