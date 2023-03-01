package ui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By emailField = By.xpath(".//input[@type='text']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By signUpButton = By.xpath(".//a[@href='/register']");
    private final By forgotPasswordButton = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter in email field on login page")
    public void inputEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Enter in password field on login page")
    public void inputPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click Enter Button on login page")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Click Sigh up button on login page")
    public void clickSighUpButton() {
        driver.findElement(signUpButton).click();
    }

    @Step("Click Forgot password button on login page")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Check redirect to login page successfully")
    public Boolean checkCreationSuccessfully() {
        return driver.findElement(forgotPasswordButton).isDisplayed();
    }
}

