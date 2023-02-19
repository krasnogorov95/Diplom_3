import com.github.javafaker.Faker;

public class UserGenerator {
    private String name;
    private String email;
    private String password;

    public UserGenerator(int randomPasswordLength) {
        Faker faker = new Faker();
        name = faker.name().fullName();
        email = faker.bothify("?????###@yandex.ru");
        password = faker.number().digits(randomPasswordLength);
    }
    public UserGenerator() {
        email = "test@default.ru";
        password = "defaultPassword";
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
