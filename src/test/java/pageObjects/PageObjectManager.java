package pageObjects;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageObjectManager {

    public LandingPage landingPage;
    public HomePage homePage;
    public WebDriver driver;
    public LoginSignUpPage loginSignUpPage;
    public ContactUsPage contactUsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() throws IOException {
        landingPage = new LandingPage(driver);
        return landingPage;
    }
    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
    public LoginSignUpPage getLoginSignUpPage() throws IOException {
        loginSignUpPage = new LoginSignUpPage(driver);
        return loginSignUpPage;
    }
    public ContactUsPage getContactUsPage() throws IOException {
        contactUsPage = new ContactUsPage(driver);
        return contactUsPage;
    }
}
