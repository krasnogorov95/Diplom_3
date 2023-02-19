import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

public class LoginTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
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
    public void logOutSuccessfully() {
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
        accountPage.clickLogOutButton();
        boolean actualResult = loginPage.checkCreationSuccessfully();
        Assert.assertTrue("Пользователь должен разлогиниться", actualResult);
    }
}
