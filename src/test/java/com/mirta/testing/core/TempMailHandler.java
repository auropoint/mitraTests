package com.mirta.testing.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideTargetLocator;
import com.mirta.testing.common.Tools;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TempMailHandler {


  public String createEmailAddress(String emailName) throws InterruptedException {
    Configuration.headless = true;
    Thread.sleep(200);
    Tools.openNewTab();
    Selenide.switchTo().window(1);
    Selenide.open("https://tempmail.plus/ru/");
    $x("//*[@placeholder='Name']").waitUntil(visible, 10000).click();
    $x("//*[@placeholder='Name']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
    $x("//*[@placeholder='Name']").sendKeys(Keys.BACK_SPACE);
    $x("//*[@placeholder='Name']").val(emailName);
    $x("//*[@id='pre_copy']").click();
    Selenide.switchTo().window(0);
    return Tools.getClipboardValue();
  }


  public void waitAndOpenEmail(Long timeoutMilliseconds) {
//    Configuration.headless = true;
//    Selenide.switchTo().window(1);
//    Selenide.open("https://tempmail.plus/ru/");
//    $x("//*[@placeholder='Name']").waitUntil(visible, timeoutMilliseconds).click();
//    $x("//*[@placeholder='Name']").sendKeys(Keys.chord(Keys.CONTROL, "a"));
//    $x("//*[@placeholder='Name']").sendKeys(Keys.BACK_SPACE);
//    $x("//*[@placeholder='Name']").val(email);
//    $x("//*[@id='pre_copy']").click();
    $x("//*[@src='/i/mail-new.svg']").waitUntil(visible, timeoutMilliseconds).click();
    $x("//*[@id='info']").shouldBe(visible);
  }

  public void exitEmail() {
    $x("//*[@id='back']").click();
  }


}
