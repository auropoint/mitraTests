package com.mirta.testing.general.steps;

import com.codeborne.selenide.Condition;
import com.mirta.testing.general.pages.*;
import io.qameta.allure.Step;

public class ShareSteps {


  AllFilesPage allFilesPage = new AllFilesPage();
  ShareModal shareModal = new ShareModal();
  PermitsModal permitsModal = new PermitsModal();
  Toasts toasts = new Toasts();
  ContextMenu contextMenu = new ContextMenu();
  CommonSteps commonSteps = new CommonSteps();
  LeftSidebar leftSidebar = new LeftSidebar();
  TrashPage trashPage = new TrashPage();
  ActionIcons actionIcons = new ActionIcons();



  @Step("Шаг - создание публикации")
  public void share(String usernameReceiver) throws InterruptedException {
    allFilesPage.initShareButton.click();
    shareModal.userShareInput.shouldBe(Condition.visible);
    Thread.sleep(400);
    shareModal.userShareInput.setValue(usernameReceiver);
    Thread.sleep(1000);
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
    allFilesPage.spinner.waitUntil(Condition.visible, 10000);
    allFilesPage.spinner.waitUntil(Condition.not(Condition.visible), 600000);
    toasts.shareSuccess.shouldBe(Condition.visible);
    toasts.toastCloser.click();

  }




}
