package com.mirta.testing.general.tests;

import com.codeborne.selenide.*;
import com.mirta.testing.core.FrameworkConfigurator;
import com.mirta.testing.general.pages.AllFilesPage;
import com.mirta.testing.general.pages.ContextMenu;
import com.mirta.testing.general.pages.LeftSidebar;
import com.mirta.testing.general.pages.Viewers;
import com.mirta.testing.general.steps.CommonSteps;
import com.mirta.testing.general.steps.FolderSteps;
import com.mirta.testing.general.steps.LoginSteps;
import com.mirta.testing.general.testData.LoginData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;
import java.util.Random;

@Feature("Функционал внутреннего пользователя")
public class InternalUserTests extends FrameworkConfigurator {

  @Test
  @DisplayName("Internal user test")
  @Severity(SeverityLevel.NORMAL)
  public void testInternalUser() throws InterruptedException, IOException {


    // login
    commonSteps.openStartPage();
    loginSteps.loginWithUsernameAndPassword(LoginData.username, LoginData.password);

    // create folder
    folderSteps.enter("AQA");
    String initialFolderName = "folder_" + new Random().nextInt(100000);
    folderSteps.create(initialFolderName);
    System.out.println(initialFolderName);

    // upload file
    File docxTextFile = new File("src/test/resources/docxTextTest.docx");
    folderSteps.enter(initialFolderName);
    folderSteps.uploadFile(docxTextFile);


    // upload folder
    File folder = new File("src/test/resources/qawa");
    folderSteps.uploadFolder(folder);


    // share folder
    folderSteps.goFolderUp();
    commonSteps.selectByCheckbox(initialFolderName);
    folderSteps.share(LoginData.usernameReceiver);


    // rename folder
    String folderName = initialFolderName + "_reamed";
    folderSteps.rename(initialFolderName, folderName);


    // download file
    folderSteps.enter(folderName);
    commonSteps.rightClick("docxTextTest.docx");
    File docxTextFileDownloaded = contextMenu.downloadFolderAsArchive.download();
    System.out.println("Downloaded FILE Path: " + docxTextFileDownloaded.getPath());
    folderSteps.goFolderUp();

    // download folder
    commonSteps.rightClick(folderName);
    File zip = contextMenu.downloadFolderAsArchive.download();
    System.out.println("Downloaded ZIP Path: " + zip.getPath());
    Thread.sleep(3000);
    Assertions.assertTrue(FolderSteps.isZipValid(zip));


    //view XLSX
    folderSteps.enter(folderName);
    folderSteps.enter("qawa");
    commonSteps.selectByCheckbox("B_1.xlsx");
    commonSteps.rightClick("B_1.xlsx");
    commonSteps.select(contextMenu.viewAsXlsx);
    viewers.xlsxViewerFileNameInHeader("B_1.xlsx").shouldBe(Condition.visible);
    viewers.xlsxViewer.shouldBe(Condition.visible);
    viewers.xlsxViewerCloser.click();

    //delete XLSX
    folderSteps.delete("B_1.xlsx");

    //recover XLSX
    folderSteps.recover("B_1.xlsx");
    allFilesPage.item("B_1" + "_restored(1)" + ".xlsx").shouldBe(Condition.visible);

    //delete folder
    folderSteps.goFolderUp();
    folderSteps.goFolderUp();
    folderSteps.delete(folderName);


    //recover folder
    folderSteps.recover(folderName);
    allFilesPage.item(folderName + "_restored(1)").shouldBe(Condition.visible);


    //delete folder at the end
    folderSteps.delete(folderName + "_restored(1)");


    //logout
    loginSteps.logout();


    Thread.sleep(3000);






  }


  FolderSteps folderSteps = new FolderSteps();
  CommonSteps commonSteps = new CommonSteps();
  LoginSteps loginSteps = new LoginSteps();
  AllFilesPage allFilesPage = new AllFilesPage();
  ContextMenu contextMenu = new ContextMenu();
  Viewers viewers = new Viewers();
  LeftSidebar leftSidebar = new LeftSidebar();

}