package com.mirta.testing.general.steps;

import com.codeborne.selenide.Condition;
import com.mirta.testing.general.pages.ActionIcons;
import com.mirta.testing.general.pages.ContextMenu;
import com.mirta.testing.general.pages.Viewers;

import static com.codeborne.selenide.Selenide.switchTo;

public class ViewerSteps {

  CommonSteps commonSteps = new CommonSteps();
  ContextMenu contextMenu = new ContextMenu();
  Viewers viewers = new Viewers();
  ActionIcons actionIcons = new ActionIcons();


  // viewAsTable

  public void viewAsTableViaContextMenu(String tableFileName) throws InterruptedException {
    commonSteps.rightClick(tableFileName);
    commonSteps.select(contextMenu.viewAsXlsx);
    viewers.fileOpenedInTableViewer.waitUntil(Condition.visible, 120000);
    viewers.viewersFileNameInHeader(tableFileName).shouldBe(Condition.visible);
    viewers.viewersCloser.click();
  }

    public void viewAsTableViaActionIcon(String tableFileName) {
    actionIcons.viewAsTableIcon(tableFileName).shouldBe(Condition.visible).click();
    viewers.fileOpenedInTableViewer.waitUntil(Condition.visible, 120000);
    viewers.viewersFileNameInHeader(tableFileName).shouldBe(Condition.visible);
    viewers.viewersCloser.click();
  }



  // viewAsPdf

    public void viewAsPdfViaContextMenu(String fileName) throws InterruptedException {
    commonSteps.rightClick(fileName);
    commonSteps.select(contextMenu.viewAsPdf);
    viewers.fileDocumentLoaderInPdfViewer.waitUntil(Condition.not(Condition.visible), 120000);
    switchTo().frame(0);
    viewers.fileOpenedInPdfViewer.waitUntil(Condition.visible, 120000);
    switchTo().parentFrame();
    viewers.viewersFileNameInHeader(fileName).shouldBe(Condition.visible);
    viewers.viewersCloser.click();
  }


    public void viewAsPdfViaActionIcon(String fileName) {
    actionIcons.viewAsPdfIcon(fileName).shouldBe(Condition.visible).click();
    viewers.fileDocumentLoaderInPdfViewer.waitUntil(Condition.not(Condition.visible), 120000);
    switchTo().frame(0);
    viewers.fileOpenedInPdfViewer.waitUntil(Condition.visible, 120000);
    switchTo().parentFrame();
    viewers.viewersFileNameInHeader(fileName).shouldBe(Condition.visible);
    viewers.viewersCloser.click();
  }




}
