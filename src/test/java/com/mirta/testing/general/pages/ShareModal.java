package com.mirta.testing.general.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShareModal {



  public SelenideElement

          userShareInput = $x("//div[@class='mb-3 input-group']/input[contains(@class, 'form-control')]"),
          addUserShareButton = $x("//div[@class='mb-3 input-group']/.//button[contains(@class, 'btn btn-primary')]"),
          setAccessPassword = $x("//input[@class='form-check-input']"),
          submitShareButton = $x("//div[@class='modal-footer']/button[contains(@class, 'btn btn-primary')]");



  public SelenideElement folder (String folderName) {
    return  $x(String.format("//div[text()='%s']", folderName));
  }

  public SelenideElement openSharePermits (String usernameReceiver) {
    return  $x(String.format("(//td[contains(text(), '%s')]/..//a[contains(@href, '#')])[1]", usernameReceiver));
  }






}
