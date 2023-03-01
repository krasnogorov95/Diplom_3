import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ui.BrowserRule;
import ui.UserGenerator;
import ui.pom.*;

public class LoginTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Log in from main page successfully")
    public void logInFromMainPageSuccessfully() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        mainPage.clickLoginButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Пользователь должен залогиниться", actualResult);
    }

    @Test
    @DisplayName("Log in from header successfully")
    public void logInFromHeaderSuccessfully() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        header.clickAccountHeaderButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Пользователь должен залогиниться", actualResult);
    }

    @Test
    @DisplayName("Log in from sigh up page successfully")
    public void logInFromSignUpPageSuccessfully() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        SignUpPage signUpPage = new SignUpPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        mainPage.clickLoginButton();
        loginPage.clickSighUpButton();
        signUpPage.clickLoginButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Пользователь должен залогиниться", actualResult);
    }

    @Test
    @DisplayName("Log in from forgot password page successfully")
    public void logInFromForgotPasswordPageSuccessfully() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickLogInButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Пользователь должен залогиниться", actualResult);
    }

    @Test
    @DisplayName("Logout successfully")
    public void logoutSuccessfully() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        Header header = new Header(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        mainPage.clickLoginButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        header.clickAccountHeaderButton();
        accountPage.clickLogoutButton();
        boolean actualResult = loginPage.checkCreationSuccessfully();
        Assert.assertTrue("Пользователь должен разлогиниться", actualResult);
    }
}
