package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PermitsModal {


  public SelenideElement

          viewInBrowser = $x("(//input[contains(@class, 'form-check-input position-static')])[1]"),
          printFromBrowser = $x("(//input[contains(@class, 'form-check-input position-static')])[2]"),
          viewXlsx = $x("(//input[contains(@class, 'form-check-input position-static')])[3]"),
          downloadFile = $x("(//input[contains(@class, 'form-check-input position-static')])[4]"),
          downloadWatermarkPdf = $x("(//input[contains(@class, 'form-check-input position-static')])[5]"),
          passwordForDownloadedPdf = $x("(//input[contains(@class, 'form-check-input position-static')])[6]"),
          allowPrintingForDownloadedPdf = $x("(//input[contains(@class, 'form-check-input position-static')])[7]"),

          allowUpload = $x("(//input[contains(@class, 'form-check-input position-static')])[8]"),
          watermarkDate = $x("(//input[contains(@class, 'form-check-input position-static')])[9]"),
          watermarkEmailReceiver = $x("(//input[contains(@class, 'form-check-input position-static')])[10]"),
          watermarkEmailSender = $x("(//input[contains(@class, 'form-check-input position-static')])[11]"),
          watermarkText = $x("(//input[contains(@class, 'form-check-input position-static')]/" +
                  "../../../..//input[contains(@class, 'form-control')])[2]"),
          allowExpirationDate = $x("(//input[contains(@class, 'form-check-input position-static')])[12]"),
          permitsSubmitButton = $x("//input[contains(@class, 'form-check-input position-static')]/" +
                  "../../../../..//button[contains(@class, 'btn btn-primary')]"),









          //folder creation
          initFolderCreationButton = $x("//div[contains(@class, 'text-right col')]/button[3]"),
          newFolderNameInput = $(By.name("folderName")),
          submitFolderCreationButton = $x("//div[contains(@class, 'modal-footer')]/button[2]"),
          uploadFileInput = $x("//input[contains(@class, 'input-file')][2]"),
          uploadFolderInput = $x("//input[contains(@class, 'input-file')][1]"),
          goFolderUp = $x("(//li//a[contains(@href, '#')])[last()]"),
          initShareButton = $x("//div[contains(@class, 'text-right col')]/button[5]");



  public SelenideElement folder (String folderName) {
    return  $x(String.format("//div[text()='%s']", folderName));
  }

  public SelenideElement openedFolder (String folderName) {
    return  $x(String.format("//li[text()='%s']", folderName));
  }




  public SelenideElement

          myPassportsPageHeader = $x("//div[@class='pageHeader']/div[text()='Мои паспорта']"),

  createNewPassportButton = $x("//button[@data-test-id='create-passport-button']"),
          createStandardPassportButton = $x("//label[@data-test-id='type-STANDARD-radio-button']"),
          createChosenKindOfPassportButton = $x("//button[@data-test-id='createPassport-button']"),

  lastPassportOpenButton = $x("//div[@class='pageHeader']/div[text()='Мои паспорта']/" +
          "following::span[text()='Активный'][1]/following::div[@class='passports_moreButton__2x4X4'][1]");

}
