package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class PracticeFormTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Test
    void fullFillFormTest() {
        loginPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Veber")
                .setEmail("aleo83@rambler.ru")
                .setGender("Male")
                .setPhoneNumber("7770658833")
                .setDateOfBirth("16", "September", "1993")
                .setSubject("English")
                .setHobbies("Music")
                .uploadPicture("121211.png")
                .setAddress("Baikonur, Street Shybnikova, d.3")
                .setState("Haryana")
                .setCity("Panipat")
                .clickButton("#submit")
                //проверить поля на заполнение и соответствие
                .checkResultComponent("Alexander Veber", "aleo83@rambler.ru", "Male",
                        "7770658833", "16 September,1993", "English", "Music",
                        "121211.png", "Baikonur, Street Shybnikova, d.3", "Haryana Panipat");
    }

    @Test
    void requiredFillFormTest() {
        loginPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Veber")
                .setGender("Male")
                .setPhoneNumber("7770658833")
                .clickButton("#submit")
                .checkResult("Student Name", "Alexander Veber")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7770658833");
    }

    @Test
    void nonFirstNameFillFormTest() {
        loginPage.openPage()
                .setFirstName("")
                .setLastName("Veber")
                .setGender("Male")
                .setPhoneNumber("7770658833")
                .clickButton("#submit")
                .checkErrorColorInput("rgb(220, 53, 69)");
    }
}
