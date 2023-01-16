package com.mirta.testing.general.steps;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mirta.testing.general.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

import static com.codeborne.selenide.Selenide.actions;

public class FolderSteps{



  AllFilesPage allFilesPage = new AllFilesPage();
  ShareModal shareModal = new ShareModal();
  PermitsModal permitsModal = new PermitsModal();
  Toasts toasts = new Toasts();
  ContextMenu contextMenu = new ContextMenu();
  CommonSteps commonSteps = new CommonSteps();
  LeftSidebar leftSidebar = new LeftSidebar();
  TrashPage trashPage = new TrashPage();

  @Step("Шаг - создание папки")
  public void create(String newFolderName) {
    allFilesPage.initFolderCreationButton.click();
    allFilesPage.newFolderNameInput.setValue(newFolderName);
    allFilesPage.submitFolderCreationButton.click();

  }

  @Step("Шаг - вход в папку")
  public void enter(String folderName) {
    allFilesPage.item(folderName).doubleClick();
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.openedFolder(folderName).shouldBe(Condition.visible);

  }

  @Step("Шаг - загрузка папки")
  public void uploadFolder(File folder) throws InterruptedException {
    allFilesPage.uploadFolderInput.uploadFile(folder);
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.item(folder.getName()).shouldBe(Condition.visible);
    toasts.toastCloser.click();
  }

  @Step("Шаг - загрузка файла")
  public void uploadFile(File file) throws InterruptedException {
    allFilesPage.uploadFileInput.uploadFile(file);
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.item(file.getName()).shouldBe(Condition.visible);
    toasts.toastCloser.click();
  }

  @Step("Шаг - выход из папки наверх")
  public void goFolderUp() {
    allFilesPage.goFolderUp.click();
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));
  }


   @Step("Шаг - создание публикации")
  public void share(String usernameReceiver) throws InterruptedException {
    allFilesPage.initShareButton.click();
    shareModal.userShareInput.setValue(usernameReceiver);
    Thread.sleep(400);
    shareModal.addUserShareButton.click();
    shareModal.openSharePermits(usernameReceiver).click();

    permitsModal.viewInBrowser.setSelected(true);
    permitsModal.printFromBrowser.setSelected(true);
    permitsModal.viewXlsx.setSelected(true);
    permitsModal.downloadFile.setSelected(true);
    permitsModal.downloadWatermarkPdf.setSelected(true);
    permitsModal.passwordForDownloadedPdf.setSelected(true);
    permitsModal.allowPrintingForDownloadedPdf.setSelected(true);
    permitsModal.allowUpload.setSelected(true);
    permitsModal.watermarkDate.setSelected(true);
    permitsModal.watermarkEmailReceiver.setSelected(true);
    permitsModal.watermarkEmailSender.setSelected(true);
    permitsModal.watermarkText.setValue("aqa_watermark");
    permitsModal.allowExpirationDate.setSelected(false);
    permitsModal.permitsSubmitButton.click();

    shareModal.setAccessPassword.setSelected(false);
    shareModal.submitShareButton.click();
    toasts.shareSuccess.shouldBe(Condition.visible);
    toasts.toastCloser.click();

  }


  @Step("Шаг - переименование файла/папки")
  public void rename(String initialItemName, String newItemName) throws InterruptedException {
    commonSteps.rightClick(initialItemName);
    contextMenu.rename.click();
    Thread.sleep(300);
    allFilesPage.renameInput.shouldBe(Condition.visible);
    allFilesPage.renameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    allFilesPage.renameInput.sendKeys(Keys.BACK_SPACE);
    allFilesPage.renameInput.setValue(newItemName);
    allFilesPage.confirmRenameButton.click();
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));
    allFilesPage.item(newItemName).shouldBe((Condition.visible));
  }

  @Step("Шаг - удаление файла/папки")
  public void delete(String itemName) throws InterruptedException {
    commonSteps.selectByCheckbox(itemName);
    allFilesPage.initDeleteButton.click();
    Thread.sleep(300);
    if (commonSteps.isItemPresent(allFilesPage.confirmDeleteButton)) {
      allFilesPage.confirmDeleteButton.click();
    }
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));
    allFilesPage.item(itemName).shouldBe(Condition.not(Condition.visible));

  }


  @Step("Шаг - восстановление файла/папки")
  public void recover(String itemName) {
    leftSidebar.trashButton.click();
    commonSteps.selectByCheckbox(itemName);
    trashPage.restoreButton.click();
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));
    leftSidebar.allFilesButton.click();
    allFilesPage.spinner.shouldBe(Condition.not(Condition.visible));

  }

  @Step("Шаг - проверка неповреждённости архива")
  public static boolean isZipValid(final File file) {
    ZipFile zipfile = null;
    try {
      zipfile = new ZipFile(file);
      return true;
    } catch (IOException e) {
      return false;
    } finally {
      try {
        if (zipfile != null) {
          zipfile.close();
          zipfile = null;
        }
      } catch (IOException e) {
      }
    }
  }





}
