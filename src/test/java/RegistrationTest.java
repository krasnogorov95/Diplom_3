import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.Header;
import pom.LoginPage;
import pom.SignUpPage;

public class RegistrationTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void userCanBeCreated() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        SignUpPage signUpPage = new SignUpPage(browserRule.getDriver());
        UserGenerator user = new UserGenerator(6);
        header.clickAccountHeaderButton();
        loginPage.clickSighUpButton();
        signUpPage.inputNameField(user.getName());
        signUpPage.inputEmailField(user.getEmail());
        signUpPage.inputPasswordField(user.getPassword());
        signUpPage.clickSignUpButton();
        boolean actualResult = loginPage.checkCreationSuccessfully();
        Assert.assertTrue("Аккаунт должен быть создан", actualResult);
    }

    @Test
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
