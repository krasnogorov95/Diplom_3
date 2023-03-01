package ui.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    private final By logoutButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check redirect to account page successfully")
    public boolean checkRedirectedSuccessfully() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Click Logout button")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
