import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ui.BrowserRule;
import ui.UserGenerator;
import ui.pom.AccountPage;
import ui.pom.Header;
import ui.pom.LoginPage;
import ui.pom.MainPage;

public class RedirectTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Account button redirects to account page")
    public void accountButtonRedirectToAccountPage() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        header.clickAccountHeaderButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        header.clickAccountHeaderButton();
        boolean actualResult = accountPage.checkRedirectedSuccessfully();
        Assert.assertTrue("Должно переходить на страницу профиля", actualResult);
    }

    @Test
    @DisplayName("Logo redirects to main page")
    public void logoRedirectToMainPage() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        header.clickAccountHeaderButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        header.clickAccountHeaderButton();
        header.clickLogo();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Должно переходить на главную страницу", actualResult);
    }

    @Test
    @DisplayName("Constructor button redirects to main page")
    public void constructorButtonRedirectToMainPage() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        UserGenerator defaultUser = new UserGenerator();
        header.clickAccountHeaderButton();
        loginPage.inputEmailField(defaultUser.getEmail());
        loginPage.inputPasswordField(defaultUser.getPassword());
        loginPage.clickEnterButton();
        header.clickAccountHeaderButton();
        header.clickConstructor();
        boolean actualResult = mainPage.checkRedirectSuccessfully();
        Assert.assertTrue("Должно переходить на главную страницу", actualResult);
    }
}
