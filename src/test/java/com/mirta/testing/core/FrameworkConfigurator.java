package com.mirta.testing.core;

import com.codeborne.selenide.*;
import com.mirta.testing.Properties;
import com.mirta.testing.common.Tools;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.mirta.testing.core.AttachmentsHelper.*;

public class FrameworkConfigurator {

    private static final Logger log = LogManager.getLogger(FrameworkConfigurator.class);

    @BeforeEach
    public void setUp() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true));
        recognizeFrameworkSettings();
    }

    @AfterEach
    public void tearDown() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();
        closeWebDriver();
    }

    /**
     * Метод, загружающий настройки в селенид, исходя из заданных в системе и enum Props
     */
    public void recognizeFrameworkSettings(){
        if (Properties.showStartupLogs.val.equals("true")) {
            try (InputStream input = new FileInputStream("src/test/resources/junit-platform.properties")) {
                java.util.Properties prop = new java.util.Properties();
                prop.load(input);
                log.info("Заданное количество параллельных потоков (файл junit-platform.properties): " +
                        prop.getProperty("junit.jupiter.execution.parallel.config.fixed.parallelism"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Configuration.browser = Tools.getRunOptionFromSystemOrProps(Properties.browser.name());
        Configuration.timeout = Integer.parseInt(Tools.getRunOptionFromSystemOrProps
                (Properties.elementsWaitTimeout.name()));
        Configuration.startMaximized = Boolean.parseBoolean(Tools.getRunOptionFromSystemOrProps
                (Properties.startMaximized.name()));
        if (Tools.getRunOptionFromSystemOrProps
                (Properties.testInstanceDestination.name()).equals("selenoid")) {
            String finalSelenoidAddress = Properties.selenoidAddress.val + ":" + Properties.selenoidPort.val + "/wd/hub/";
            log.info("Тесты будут запущены в инстансе селеноида: " + finalSelenoidAddress);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities = Tools.getCapabilityFromSystemOrProps(capabilities,
                    Properties.enableVideo.name());
            capabilities = Tools.getCapabilityFromSystemOrProps(capabilities,
                    Properties.enableVNC.name());

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = finalSelenoidAddress;
        }
    }
}
