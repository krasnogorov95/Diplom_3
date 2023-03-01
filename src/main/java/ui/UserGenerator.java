package ui;

import com.github.javafaker.Faker;

public class UserGenerator {
    private static boolean isRandom;
    private final String email;
    private final String password;
    private String name;

    public UserGenerator(int randomPasswordLength) {
        Faker faker = new Faker();
        name = faker.name().fullName();
        email = faker.bothify("?????###@yandex.ru");
        password = faker.number().digits(randomPasswordLength);
        isRandom = true;
    }


    public UserGenerator() {
        email = "test@default.ru";
        password = "defaultPassword";
    }

    public static boolean isRandom() {
        return isRandom;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
