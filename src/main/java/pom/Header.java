package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;
    private final By constructor = By.xpath(".//*[text()='Конструктор']");
    private final By logo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By accountHeaderButton = By.xpath(".//a[@href='/account']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAccountHeaderButton() {
        driver.findElement(accountHeaderButton).click();
    }
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    public void clickConstructor() {
        driver.findElement(constructor).click();
    }
}
