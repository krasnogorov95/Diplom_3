package pom;

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
    public void inputNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public boolean checkErrorPasswordIsDisplayed(){
        return driver.findElement(errorPasswordLabel).isDisplayed();
    }
}
