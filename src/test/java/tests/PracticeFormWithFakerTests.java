package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static utils.RandomUtils.*;

public class PracticeFormWithFakerTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    String firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            userGender = getGender(),
            userMobileNumber = getMobileNumber(),
            userBirthDay = getBirthDay(),
            userBirthMonth = getBirthMonth(),
            userBirthYear = getBirthYear(),
            userSubject = getSubject(),
            userHobbie = getHobbie(),
            userPicture = getPicture(),
            streetAddress = getAddress(),
            userState = getState(),
            userCity = getCity();

    @Test
    void fullFillFormTest() {
        loginPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userMobileNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobbies(userHobbie)
                .uploadPicture(userPicture)
                .setAddress(streetAddress)
                .setState(userState)
                .setCity(userCity)
                .clickButton()
                //проверить поля на заполнение и соответствие
                .checkResultComponent(firstName + " " + lastName, userEmail, userGender,
                        userMobileNumber, userBirthDay + " " + userBirthMonth + "," + userBirthYear, userSubject, userHobbie,
                        userPicture, streetAddress, userState + " " + userCity);
    }

    @Test
    void requiredFillFormTest() {
        loginPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhoneNumber(userMobileNumber)
                .clickButton()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userMobileNumber);
    }

    @Test
    void nonFirstNameFillFormTest() {
        loginPage.openPage()
                .setFirstName("")
                .setLastName(lastName)
                .setGender(userGender)
                .setPhoneNumber(userMobileNumber)
                .clickButton()
                .checkErrorColorInput("rgb(220, 53, 69)");
    }
}