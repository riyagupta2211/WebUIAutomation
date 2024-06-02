package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By login = By.xpath("//div//li/a[@href=\"/login\"]");
    public void clickLoginSignUp() {
        driver.findElement(login).click();
    }
    public boolean loginSignUpIsVisible() {
        return driver.findElement(login).isDisplayed();
    }
}
