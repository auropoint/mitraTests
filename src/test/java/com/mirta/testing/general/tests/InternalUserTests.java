package com.mirta.testing.general.tests;

import com.codeborne.selenide.*;
import com.mirta.testing.core.FrameworkConfigurator;
import com.mirta.testing.general.pages.*;
import com.mirta.testing.general.steps.*;
import com.mirta.testing.general.testData.LoginData;
import io.qameta.allure.*;
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


    // Internal user


    // login
    commonSteps.openStartPage();
    loginSteps.loginInternalUserWithUsernameAndPassword(LoginData.username, LoginData.password);

    // create folder
    folderSteps.enter("AQA");
    String folderId = "" + new Random().nextInt(100000);
    String initialTestFolderName = "folder_" + folderId;
    folderSteps.create(initialTestFolderName);
    System.out.println("Test folder name : " + initialTestFolderName);

    // upload file
    File docxTextFile = new File("src/test/resources/docxTextTest.docx");
    folderSteps.enter(initialTestFolderName);
    folderSteps.uploadFile(docxTextFile);

    // upload folder
    File folder = new File("src/test/resources/qawa");
    folderSteps.uploadFolder(folder);

    folderSteps.goFolderUp();

    // share folder with a new external user
    String externalUserEmail = emailSteps.getNewEmailAddress("external_" + folderId);
    commonSteps.selectByCheckbox(initialTestFolderName);
    shareSteps.share(externalUserEmail);
    System.out.println("ExternalUserEmail : " + externalUserEmail);

    // rename folder
    String testFolderName = initialTestFolderName + "_reamed";
    folderSteps.rename(initialTestFolderName, testFolderName);

    // share folder with internal user
    commonSteps.selectByCheckbox(testFolderName);
    shareSteps.share(LoginData.usernameReceiver);

    // share folder with an existing external user
    commonSteps.selectByCheckbox(testFolderName);
    shareSteps.share("bogdanovich@mitrasoft.ru");

    folderSteps.enter(testFolderName);

    // download file
    folderSteps.downloadFileViaContextMenu(docxTextFile.getName());

    folderSteps.goFolderUp();

    // download folder
    folderSteps.downloadFolderViaContextMenu(testFolderName);


    folderSteps.enter(testFolderName);
    folderSteps.enter(folder.getName());

    // download file as PDF - with or without password
//    folderSteps.downloadFolderViaContextMenu(testFolderName);






    //view files
    viewerSteps.viewAsTableViaContextMenu("B_1.xlsx");
    viewerSteps.viewAsPdfViaContextMenu("pdf_1.pdf");
    viewerSteps.viewAsPdfViaContextMenu("word_1.docx");
    viewerSteps.viewAsPdfViaContextMenu("notepad_1.txt");
    viewerSteps.viewAsPdfViaContextMenu("B_1.xlsx");

    //delete XLSX
    folderSteps.delete("B_1.xlsx");

    //recover XLSX
    folderSteps.recover("B_1.xlsx");
    allFilesPage.item("B_1" + "_restored(1)" + ".xlsx").shouldBe(Condition.visible);

    //logout
    loginSteps.logout();




    // External user

    loginSteps.loginExternalUserWithEmailAndOtp(emailSteps, externalUserEmail);
    allFilesPage.item(docxTextFile.getName()).shouldBe(Condition.visible);
    allFilesPage.item(folder.getName()).shouldBe(Condition.visible);

    // download file
    folderSteps.downloadFileViaActionIcon(docxTextFile.getName());

    // download folder
    folderSteps.downloadFolderViaActionIcon(folder.getName());



    //view files
    folderSteps.enter(folder.getName());
    viewerSteps.viewAsTableViaActionIcon("B_1_restored(1).xlsx");
    viewerSteps.viewAsPdfViaActionIcon("pdf_1.pdf");
    viewerSteps.viewAsPdfViaActionIcon("word_1.docx");
    viewerSteps.viewAsPdfViaActionIcon("notepad_1.txt");
    viewerSteps.viewAsPdfViaActionIcon("B_1_restored(1).xlsx");






    Thread.sleep(10000000);




    // Internal user


    //delete folder
    folderSteps.goFolderUp();
    folderSteps.goFolderUp();
    folderSteps.delete(testFolderName);

    //recover folder
    folderSteps.recover(testFolderName);
    allFilesPage.item(testFolderName + "_restored(1)").shouldBe(Condition.visible);

    //delete folder at the end
    folderSteps.delete(testFolderName + "_restored(1)");




    Thread.sleep(3000);






  }


  FolderSteps folderSteps = new FolderSteps();
  CommonSteps commonSteps = new CommonSteps();
  LoginSteps loginSteps = new LoginSteps();
  AllFilesPage allFilesPage = new AllFilesPage();
  ContextMenu contextMenu = new ContextMenu();
  Viewers viewers = new Viewers();
  LeftSidebar leftSidebar = new LeftSidebar();
  EmailSteps emailSteps = new EmailSteps();
  ViewerSteps viewerSteps = new ViewerSteps();
  ShareSteps shareSteps = new ShareSteps();

}