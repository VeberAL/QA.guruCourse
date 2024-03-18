package tests.remotetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remote = System.getProperty("remote");
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion");

        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.remote = remote;
        Configuration.timeout = 10000;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
