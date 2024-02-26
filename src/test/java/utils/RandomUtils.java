package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en"));
    static String firstName, lastName, userEmail, streetAddress, userGender, userMobileNumber, userBirthYear,
            userBirthMonth, userBirthDay, userSubject, userHobbie, userPicture, userState, userCity;

    public static String getFirstName() {
        return firstName = faker.name().firstName();
    }

    public static String getLastName() {
        return lastName = faker.name().lastName();
    }

    public static String getEmail() {
        return userEmail = faker.internet().emailAddress();
    }

    public static String getAddress() {
        return streetAddress = faker.address().streetAddress();
    }

    public static String getGender() {
        return userGender = faker.options().option("Male", "Female", "Other");
    }

    public static String getMobileNumber() {
        return userMobileNumber = faker.phoneNumber().subscriberNumber(10);
    }

    public static String getBirthYear() {
        return userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2023));
    }

    public static String getBirthMonth() {
        return userBirthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public static String getBirthDay() {
        return userBirthDay = String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getSubject() {
        return userSubject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies");
    }

    public static String getHobbie() {
        return userHobbie = faker.options().option("Sports", "Reading", "Music");
    }

    public static String getPicture() {
        return userPicture = faker.options().option("21.jpg", "12.png");
    }

    public static String getState() {
        return userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity() {
        String randomNCRCity = faker.options().option("Delhi", "Gurgaon", "Noida"),
                randomUttarPradeshCity = faker.options().option("Agra", "Lucknow", "Merrut"),
                randomHaryanaCity = faker.options().option("Karnal", "Panipat"),
                randomRajasthanCity = faker.options().option("Jaipur", "Jaiselmer");

        if (userState == "NCR")
            userCity = randomNCRCity;
        else if (userState == "Uttar Pradesh")
            userCity = randomUttarPradeshCity;
        else if (userState == "Haryana")
            userCity = randomHaryanaCity;
        else
            userCity = randomRajasthanCity;
        return userCity;
    }
}
