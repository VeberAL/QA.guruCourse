package tests.remotetest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static io.qameta.allure.Allure.step;

public class PracticeFormRemoteTests extends TestBase {
    LoginPage loginPage = new LoginPage();


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
    @Tags({@Tag("demoqa"), @Tag("smoke")})
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
    @DisplayName("Заполнение не всех обязательных полей формы demoqa и проверка заполнения.")
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