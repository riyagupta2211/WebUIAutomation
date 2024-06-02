package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginSignUpPage {
    public WebDriver driver;
    Properties constants = new Properties();
    //public static final String LOGIN_SIGNUP_PAGE_TITLE = "Automation Exercise - Signup / Login";
    String loginSignUpPageTitle;
    public LoginSignUpPage(WebDriver driver) throws IOException {

        this.driver = driver;
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Constants.properties");
        constants.load(in);
    }
    String LoginSignUpPageTitle;
    By loginSignUpText = By.xpath("//div//h2[text() = 'New User Signup!']");
    By email = By.xpath("//form[@action = \"/signup\"]//input[@placeholder='Email Address' and @data-qa = \"signup-email\"]");
    By name = By.xpath("//form[@action = \"/signup\"]//input[@placeholder='Name']");
    By signUp = By.xpath("//form//button[@type='submit' and @data-qa = \"signup-button\"]");
    By login_email = By.xpath("//form[@action=\"/login\"]/input[@data-qa=\"login-email\"]");
    By login_password = By.xpath("//form[@action=\"/login\"]/input[@data-qa=\"login-password\"]");

    public String loginSignUpTextIsVisible(String signUpText) {
        return driver.findElement(By.xpath("//div//h2[text() = '" + signUpText+"']")).getText();
    }
    public void signUpDetails( String nameForSignUp,String emailForSignUp) throws InterruptedException {
        driver.findElement(name).sendKeys(nameForSignUp);
        driver.findElement(email).sendKeys(emailForSignUp);
    }
    public void clickSignUpButton() {
        driver.findElement(signUp).click();
    }
    public void loginDetails(String email_address, String password) throws InterruptedException {
        driver.findElement(login_email).sendKeys(email_address);
        driver.findElement(login_password).sendKeys(password);
    }
    public void errorMessageVisibilityCheck(String error_message) {
        String actual_error_message = driver.findElement(By.xpath("//*[text() = '" + error_message + "']")).getText();
        Assert.assertEquals(actual_error_message,error_message);
    }
    public void userNavigationToLoginSignUpPage(String title) {
        //title = LOGIN_SIGNUP_PAGE_TITLE;
        LoginSignUpPageTitle = constants.getProperty(title);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,LoginSignUpPageTitle);
    }
}
