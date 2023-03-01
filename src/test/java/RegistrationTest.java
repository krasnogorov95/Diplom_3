import api.UserClient;
import api.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ui.BrowserRule;
import ui.UserGenerator;
import ui.pom.Header;
import ui.pom.LoginPage;
import ui.pom.SignUpPage;

public class RegistrationTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();
    private String accessToken;
    private UserClient userClient;

    @After
    public void cleanUp() {
        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }

    @Test
    @DisplayName("User can be created")
    public void userCanBeCreated() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        SignUpPage signUpPage = new SignUpPage(browserRule.getDriver());
        UserGenerator user = new UserGenerator(6);
        userClient = new UserClient();
        UserCredentials credentials = UserCredentials.from(user);
        header.clickAccountHeaderButton();
        loginPage.clickSighUpButton();
        signUpPage.inputNameField(user.getName());
        signUpPage.inputEmailField(user.getEmail());
        signUpPage.inputPasswordField(user.getPassword());
        signUpPage.clickSignUpButton();
        ValidatableResponse loginResponse = userClient.login(credentials);
        accessToken = loginResponse.extract().path("accessToken");
        boolean actualResult = loginPage.checkCreationSuccessfully();
        Assert.assertTrue("Аккаунт должен быть создан", actualResult);
    }

    @Test
    @DisplayName("Creating user with short password calls error label")
    public void createUserWithShortPasswordCallErrorLabel() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        SignUpPage signUpPage = new SignUpPage(browserRule.getDriver());
        UserGenerator user = new UserGenerator(5);
        header.clickAccountHeaderButton();
        loginPage.clickSighUpButton();
        signUpPage.inputNameField(user.getName());
        signUpPage.inputEmailField(user.getEmail());
        signUpPage.inputPasswordField(user.getPassword());
        signUpPage.clickSignUpButton();
        boolean actualResult = signUpPage.checkErrorPasswordIsDisplayed();
        Assert.assertTrue("Ошибка должна отображаться", actualResult);
    }
}
