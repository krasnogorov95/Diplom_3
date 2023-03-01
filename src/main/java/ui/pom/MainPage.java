package ui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunsUnselectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By saucesUnselectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingUnselectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By bunsSelectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By saucesSelectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingSelectedConstructor = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Log in button on main page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Check redirect to main page successfully")
    public boolean checkRedirectSuccessfully() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Click Sauces in constructor")
    public void clickSaucesConstructor() {
        driver.findElement(saucesUnselectedConstructor).click();
    }

    @Step("Click Filling in constructor")
    public void clickFillingConstructor() {
        driver.findElement(fillingUnselectedConstructor).click();
    }

    @Step("Click Buns in constructor")
    public void clickBunsConstructor() {
        driver.findElement(bunsUnselectedConstructor).click();
    }

    @Step("Check Sauces in constructor is selected")
    public boolean checkSelectedSaucesConstructorIsDisplayed() {
        return driver.findElement(saucesSelectedConstructor).isDisplayed();
    }

    @Step("Check Filling in constructor is selected")
    public boolean checkSelectedFillingConstructorIsDisplayed() {
        return driver.findElement(fillingSelectedConstructor).isDisplayed();
    }

    @Step("Check Buns in constructor is selected")
    public boolean checkSelectedBunsConstructorIsDisplayed() {
        return driver.findElement(bunsSelectedConstructor).isDisplayed();
    }
}
