import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ui.BrowserRule;
import ui.pom.MainPage;

public class ConstructorTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Select Sauces in burger's constructor change constructor's section")
    public void selectSaucesConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickSaucesConstructor();
        boolean actualResult = mainPage.checkSelectedSaucesConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Соусы", actualResult);
    }

    @Test
    @DisplayName("Select Filling in burger's constructor change constructor's section")
    public void selectFillingConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickFillingConstructor();
        boolean actualResult = mainPage.checkSelectedFillingConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Начинки", actualResult);
    }

    @Test
    @DisplayName("Select Buns in burger's constructor change constructor's section")
    public void selectBunsConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickFillingConstructor();
        mainPage.clickBunsConstructor();
        boolean actualResult = mainPage.checkSelectedBunsConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Булки", actualResult);
    }
}
