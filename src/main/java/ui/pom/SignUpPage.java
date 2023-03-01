package ui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text()='Имя']/..//input");
    private final By emailField = By.xpath(".//label[text()='Email']/..//input");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By signUpButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By errorPasswordLabel = By.xpath(".//p[@class='input__error text_type_main-default']");
    private final By loginButton = By.xpath(".//a[@href='/login']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter in name field on sign up page")
    public void inputNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Enter in email field on sign up page")
    public void inputEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Enter in password field on sign up page")
    public void inputPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click Sign up button on sign up page")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    @Step("Click Log in button on sign up page")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Check error password is displayed")
    public boolean checkErrorPasswordIsDisplayed() {
        return driver.findElement(errorPasswordLabel).isDisplayed();
    }
}
