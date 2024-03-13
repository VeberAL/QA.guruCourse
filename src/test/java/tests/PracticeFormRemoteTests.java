package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class PracticeFormRemoteTests {
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

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

    @Test
    @DisplayName("Заполнение всех полей формы demoqa и проверка заполнения.")
    @Tag("demoqa")
    void fullFillFormTest() {
        step("Открыть форму.", () -> loginPage.openPage());
        step("Заполнить форму.", () -> {
            loginPage.setFirstName("Alexander")
                    .setLastName("Veber")
                    .setEmail("aleo83@rambler.ru")
                    .setGender("Male")
                    .setPhoneNumber("7770658833")
                    .setDateOfBirth("16", "September", "1993")
                    .setSubject("English")
                    .setHobbies("Music")
                    .uploadPicture("12.png")
                    .setAddress("Baikonur, Street Shybnikova, d.3")
                    .setState("Haryana")
                    .setCity("Panipat");
        });
        step("Отправить данные.", () -> loginPage.clickButton());
        step("Проверить данные на соответствие.", () -> {
            loginPage.checkResult("Student Name", "Alexander Veber")
                    .checkResult("Student Email", "aleo83@rambler.ru")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "7770658833")
                    .checkResult("Date of Birth", "16 September,1993")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Music")
                    .checkResult("Picture", "12.png")
                    .checkResult("Address", "Baikonur, Street Shybnikova, d.3")
                    .checkResult("State and City", "Haryana Panipat");
        });
    }

    @Test
    @DisplayName("Заполнение обязательных полей формы demoqa и проверка заполнения.")
    @Tag("demoqa")
    void requiredFillFormTest() {
        step("Открыть форму.", () -> loginPage.openPage());
        step("Заполнить форму.", () -> {
            loginPage.setFirstName("Alexander")
                    .setLastName("Veber")
                    .setGender("Male")
                    .setPhoneNumber("7770658833");
        });
        step("Отправить данные.", () -> loginPage.clickButton());
        step("Проверить обязательные данные на соответствие.", () -> {
            loginPage.checkResult("Student Name", "Alexander Veber")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "7770658833");
        });
    }

    @Test
    @Tag("demoqa")
    void nonFirstNameFillFormTest() {
        step("Открыть форму.", () -> loginPage.openPage());
        step("Заполнить обязательные поля формы без ввода имени.", () -> {
            loginPage.setFirstName("")
                    .setLastName("Veber")
                    .setGender("Male")
                    .setPhoneNumber("7770658833");
        });
        step("Отправить данные.", () -> loginPage.clickButton());
        step("Проверить появление предупреждения о незаполнении всех обязательных полей формы.", () ->
                loginPage.checkNotVisibleResultTable());
    }
}