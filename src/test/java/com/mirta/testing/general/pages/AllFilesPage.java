package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AllFilesPage {

  private String folderName;

  public SelenideElement

          //folder creation
          initFolderCreationButton = $x("//div[contains(@class, 'text-right col')]/button[3]"),
          newFolderNameInput = $(By.name("folderName")),
          submitFolderCreationButton = $x("//div[contains(@class, 'modal-footer')]/button[2]"),
          uploadFileInput = $x("//input[contains(@class, 'input-file')][2]"),
          uploadFolderInput = $x("//input[contains(@class, 'input-file')][1]"),
          goFolderUp = $x("(//li//a[contains(@href, '#')])[last()]"),
          initShareButton = $x("//div[contains(@class, 'text-right col')]/button[5]"),
          initDeleteButton = $x("//div[contains(@class, 'text-right col')]/button[6]"),
          confirmDeleteButton = $x("//button[@class='btn btn-danger']"),
          spinner = $x("//div[@class='spinner-border text-primary']"),

  // rename modal
          renameInput = $x("//input[@name='folderName']"),
          confirmRenameButton = $x("(//button[@class='btn btn-primary'])[2]"),


  // file upload modal
  waitingUploadStartClockIcon = $x("//a[@class='text-decoration-none icon icon-ext-clock']");


  public SelenideElement item(String itemName) {
    return $x(String.format("//div[text()='%s']", itemName));
  }

  public SelenideElement itemSelctedCheckbox(String itemName) {
    return $x(String.format("//div[text()='%s']/../../..//div[contains(@class, 'file-selector selected')]", itemName));
  }

  public SelenideElement openedFolder(String folderName) {
    return $x(String.format("//li[text()='%s']", folderName));
  }



}
