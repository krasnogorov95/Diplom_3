import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;

public class ConstructorTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void selectSaucesConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickSaucesConstructor();
        boolean actualResult = mainPage.checkSelectedSaucesConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Соусы", actualResult);
    }

    @Test
    public void selectFillingConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickFillingConstructor();
        boolean actualResult = mainPage.checkSelectedFillingConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Начинки", actualResult);
    }

    @Test
    public void selectBunsConstructorChangeSection() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.clickFillingConstructor();
        mainPage.clickBunsConstructor();
        boolean actualResult = mainPage.checkSelectedBunsConstructorIsDisplayed();
        Assert.assertTrue("Должен перейти к разделу Булки", actualResult);
    }
}
