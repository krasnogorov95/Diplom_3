import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.MainPage;

public class RedirectTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
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
    public void logoRedirectToMainPage() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());
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
    public void constructorButtonRedirectToMainPage() {
        Header header = new Header(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());
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
