package com.mirta.testing.general.steps;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TempMailHandler {

    public String waitAndGetMail(String mailAddress, Long timeToWaitInSec) {
//        Configuration.headless = true;
        Selenide.open("https://tempmail.plus/ru/");
        $x("//*[@placeholder='Name']").waitUntil(visible, timeToWaitInSec).click();
        for (int i = 0; i <= 15; i++) {
            $x("//*[@placeholder='Name']").sendKeys(Keys.BACK_SPACE);
        }
        $x("//*[@placeholder='Name']").val(mailAddress);
        $x("//*[@id='pre_copy']").click();
        $x("//*[@src='/i/mail-new.svg']")
                .waitUntil(visible, timeToWaitInSec).click();
        $x("//*[@id='info']").shouldBe(visible);


        //ссылка на шару
        return $x("//center/a").getAttribute("href");

        //отп
        //   //h4[2]    Пароль : 218598
        //!changeMe123

        // Пароль для доступа к файлу ПДФ
        //   //h4/text()[2]      ": YaAJg(>Z

    }


    public void bindMailAddress() {
//        Configuration.headless = true;
        Selenide.open("https://tempmail.plus/ru/");
        $x("//*[@placeholder='Name']").waitUntil(visible, 10).click();
        for (int i = 0; i <= 15; i++) {
            $x("//*[@placeholder='Name']").sendKeys(Keys.BACK_SPACE);
        }
        $x("//*[@placeholder='Name']").val("vnghv");
        $x("//*[@id='pre_copy']").click();
    }
}
