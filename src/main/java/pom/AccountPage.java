package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    private final By logOutButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean checkRedirectedSuccessfully(){
        return driver.findElement(logOutButton).isDisplayed();
    }
    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }
}
