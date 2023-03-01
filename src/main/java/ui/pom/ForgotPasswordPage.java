package ui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final By logInButton = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Log in button on forgot password page")
    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }
}
