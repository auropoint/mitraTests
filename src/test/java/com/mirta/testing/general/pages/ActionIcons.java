package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ActionIcons {


  public SelenideElement downloadOriginalFileIcon(String fileName) {
    return $x(String.format("//*[text()='%s']/ancestor::tr//*[@class='text-decoration-none icon icon-ext-file-empty']", fileName));
  }

  public SelenideElement downloadFolderIcon(String folderName) {
    return $x(String.format("//*[text()='%s']/ancestor::tr//*[@class='text-decoration-none icon icon-ext-folder-download']", folderName));
  }

  public SelenideElement viewAsTableIcon(String tableFileName) {
    return $x(String.format("//*[text()='%s']/ancestor::tr//*[@class='text-decoration-none icon icon-ext-file-excel']", tableFileName));
  }

    public SelenideElement viewAsPdfIcon(String tableFileName) {
    return $x(String.format("//*[text()='%s']/ancestor::tr//*[@class='text-decoration-none icon icon-ext-eye']", tableFileName));
  }

    public SelenideElement downloadAsPdfFileIcon(String fileName) {
    return $x(String.format("//*[text()='%s']/ancestor::tr//*[@class='text-decoration-none icon icon-ext-file-pdf']", fileName));
  }




}
