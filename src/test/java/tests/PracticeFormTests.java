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
                .uploadPicture("12.png")
                .setAddress("Baikonur, Street Shybnikova, d.3")
                .setState("Haryana")
                .setCity("Panipat")
                .clickButton()
                //проверить поля на заполнение и соответствие
                .checkResult("Student Name", "Alexander Veber")
                .checkResult("Student Email", "aleo83@rambler.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7770658833")
                .checkResult("Date of Birth", "16 September,1993")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "12.png")
                .checkResult("Address", "Baikonur, Street Shybnikova, d.3")
                .checkResult("State and City", "Haryana Panipat");
    }

    @Test
    void requiredFillFormTest() {
        loginPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Veber")
                .setGender("Male")
                .setPhoneNumber("7770658833")
                .clickButton()
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
                .clickButton()
                .checkNotVisibleResultTable();
    }
}