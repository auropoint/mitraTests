package com.mirta.testing.general.steps;

import com.codeborne.selenide.Condition;
import com.mirta.testing.general.pages.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipFile;

public class FolderSteps {


  AllFilesPage allFilesPage = new AllFilesPage();
  ShareModal shareModal = new ShareModal();
  PermitsModal permitsModal = new PermitsModal();
  Toasts toasts = new Toasts();
  ContextMenu contextMenu = new ContextMenu();
  CommonSteps commonSteps = new CommonSteps();
  LeftSidebar leftSidebar = new LeftSidebar();
  TrashPage trashPage = new TrashPage();
  ActionIcons actionIcons = new ActionIcons();

  @Step("Шаг - создание папки")
  public void create(String newFolderName) {
    allFilesPage.initFolderCreationButton.click();
    allFilesPage.newFolderNameInput.setValue(newFolderName);
    allFilesPage.submitFolderCreationButton.click();

  }

  @Step("Шаг - вход в папку")
  public void enter(String folderName) {
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.item(folderName).shouldBe(Condition.visible).doubleClick();
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
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
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
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
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
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    allFilesPage.item(itemName).shouldBe(Condition.not(Condition.visible));
  }


  @Step("Шаг - восстановление файла/папки")
  public void recover(String itemName) {
    leftSidebar.trashButton.click();
    commonSteps.selectByCheckbox(itemName);
    trashPage.restoreButton.click();
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    leftSidebar.allFilesButton.click();
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
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

  @Step("Шаг - скачивание файла через контекстное меню")
  public void downloadFileViaContextMenu(String fileName) throws FileNotFoundException, InterruptedException {
    commonSteps.rightClick(fileName);
    File docxTextFileDownloaded = contextMenu.downloadFileOrFolderAsArchive.download();
    System.out.println("Downloaded FILE Path: " + docxTextFileDownloaded.getPath());
  }

  @Step("Шаг - скачивание файла через иконку")
   public void downloadFileViaActionIcon(String fileName) throws FileNotFoundException {
    File docxTextFileDownloaded = actionIcons.downloadOriginalFileIcon(fileName).download();
    System.out.println("Downloaded FILE Path: " + docxTextFileDownloaded.getPath());
  }

  @Step("Шаг - скачивание папки через контекстное меню")
  public void downloadFolderViaContextMenu(String folderName) throws FileNotFoundException, InterruptedException {
    commonSteps.rightClick(folderName);
    File zip = contextMenu.downloadFileOrFolderAsArchive.download();
    System.out.println("Downloaded ZIP Path: " + zip.getPath());
    Thread.sleep(5000);
//    Assertions.assertTrue(FolderSteps.isZipValid(zip));
  }

  @Step("Шаг - скачивание папки через иконку")
    public void downloadFolderViaActionIcon(String folderName) throws FileNotFoundException, InterruptedException {
    File zip = actionIcons.downloadFolderIcon(folderName).download();
    System.out.println("Downloaded ZIP Path: " + zip.getPath());
    Thread.sleep(5000);
//    Assertions.assertTrue(FolderSteps.isZipValid(zip));
  }




}
