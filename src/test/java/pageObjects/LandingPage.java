package pageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.testng.AssertJUnit.assertTrue;

public class LandingPage {
    public WebDriver driver;
    String accountInfoXpath;
    String LoggedInAsXpath;
    String UserNameXpath;
    Properties constants = new Properties();
    By title_locator = By.id("id_gender1");
    By name_locator = By.id("name");
    By password_locator = By.id("password");
    By dob_locator_days = By.xpath("//div[@id = \"uniform-days\"]/select[@id = \"days\"]");
    By dob_locator_months = By.xpath("//div[@id = \"uniform-months\"]/select[@id = \"months\"]");
    By dob_locator_year = By.xpath("//div[@id = \"uniform-years\"]/select[@id = \"years\"]");
    By address_detials_first_name = By.id("first_name");
    By address_detials_last_name = By.id("last_name");
    By address_detials_company = By.id("company");
    By address_detials_address1 = By.id("address1");
    By address_detials_address2 = By.id("address2");
    By address_details_country = By.xpath("//p//select[@id = \"country\"]");
    By address_detials_city = By.id("city");
    By address_detials_state = By.id("state");
    By address_detials_zipcode = By.id("zipcode");
    By address_detials_mobile_number = By.id("mobile_number");
   // By deleteLink = By.xpath("//a[@href=\"/delete_account\"]");
    //By adsXpath = By.xpath("//div[@id=\"dismiss-button\" and @aria-label= \"Close ad\"]");
    //By click_create_account_button = By.xpath("//button[@type = "submit" and @data-qa = "create-account"]"));

    public LandingPage(WebDriver driver) throws IOException {
        this.driver = driver;
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Constants.properties");
        constants.load(in);

    }

    public void verifyTextVisibilityWithXpath(String text, String xpath) throws InterruptedException {

        accountInfoXpath = constants.getProperty(xpath);
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'aswift_')]")));
        //driver.findElement(By.id("dismiss-button")).click(); //Close Ad
//        WebElement adElementId = driver.findElement(adsXpath);
//        removeAdByJS(adElementId);
//        driver.switchTo().defaultContent();
        String actualAccountText = driver.findElement(By.xpath(accountInfoXpath)).getText();
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'aswift_')]")));
//        removeAdByJS(adElementId);
//        driver.switchTo().defaultContent();
        Assert.assertEquals(actualAccountText, text);


    }

    public void FillInAccountDetailsWith(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> detail : details) {
            WebElement titleField = driver.findElement(title_locator);
            WebElement nameField = driver.findElement(name_locator);
            WebElement passwordField = driver.findElement(password_locator);
            Select daySelect = new Select(driver.findElement(dob_locator_days));
            Select monthSelect = new Select(driver.findElement(dob_locator_months));
            Select yearSelect = new Select(driver.findElement(dob_locator_year));

            // Entering the values from the data table
            titleField.click();
            nameField.clear();
            nameField.sendKeys(detail.get("name"));
            passwordField.clear();
            passwordField.sendKeys(detail.get("Password"));

            //Splitting the dob provided by user
            String[] dob = detail.get("Date of birth").split("/");
            String day = dob[0];
            String month = dob[1];
            String year = dob[2];

            daySelect.selectByValue(day);
            monthSelect.selectByValue(month);
            yearSelect.selectByValue(year);
        }
    }

    public void selectCheckboxWithIdentifier(String checkboxText) throws InterruptedException {
        By locator;
        switch (checkboxText) {
            case "Sign up for our newsletter!":
                locator = By.id("newsletter");
                break;
            case "Receive special offers from our partners!":
                locator = By.id("optin");
                break;
            default:
                throw new IllegalArgumentException("Unknown checkbox: " + checkboxText);
        }

        WebElement checkbox = driver.findElement(locator);
        if (!checkbox.isSelected()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);

        }
    }

    public void fillInAddressDetails(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> detail : details) {

            WebElement firstNameField = driver.findElement(address_detials_first_name);
            WebElement lastNameField = driver.findElement(address_detials_last_name);
            WebElement companyField = driver.findElement(address_detials_company);
            WebElement address1Field = driver.findElement(address_detials_address1);
            WebElement address2Field = driver.findElement(address_detials_address2);
            WebElement stateField = driver.findElement(address_detials_state);
            WebElement cityField = driver.findElement(address_detials_city);
            WebElement zipcodeField = driver.findElement(address_detials_zipcode);
            WebElement mobileNumberField = driver.findElement(address_detials_mobile_number);

            Select country = new Select(driver.findElement(address_details_country));
            firstNameField.sendKeys(detail.get("First name"));
            lastNameField.sendKeys(detail.get("Last name"));
            companyField.sendKeys(detail.get("Company"));
            address1Field.sendKeys(detail.get("Address"));
            address2Field.sendKeys(detail.get("Address2"));
            country.selectByValue(detail.get("Country"));
            stateField.sendKeys(detail.get("State"));
            cityField.sendKeys(detail.get("City"));
            zipcodeField.sendKeys(detail.get("Zipcode"));
            mobileNumberField.sendKeys(detail.get("Mobile Number"));
        }
    }

    public void clickOnButton(String buttonText) throws InterruptedException {

        WebElement buttonClick = driver.findElement(By.xpath("//*[text()='" + buttonText + "']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",buttonClick);
        //buttonClick.click();
    }
    public void verifyMultipleTextVisibilityWithMultipleXpath(String loggedIn,String loggedInXpath) throws InterruptedException {

        LoggedInAsXpath = constants.getProperty(loggedInXpath);
        //UserNameXpath = constants.getProperty(userNameXpath);
        String actualLoggedInText = driver.findElement(By.xpath(LoggedInAsXpath)).getText();
        System.out.println(actualLoggedInText);

        Assert.assertEquals(actualLoggedInText, loggedIn);
//        Thread.sleep(2000);
//        String actualUserNameText = driver.findElement(By.xpath(UserNameXpath)).getText();
//        System.out.println(actualUserNameText);
//        //Assert.assertEquals(actualUserNameText, userName);
    }
    public void clickOnLinkButton(String textcheck) {

        driver.findElement(By.xpath("//a[@href='" + textcheck +"']")).click();

    }


//    public void verifyTextVisibilityWithXpath(String Text) throws InterruptedException {
//        By locator;
//        switch (Text) {
//            case "ENTER ACCOUNT INFORMATION":
//                locator = By.xpath("(//div[@class=\"login-form\"]//h2)[1]//b");
//                break;
//            case "ACCOUNT CREATED!":
//                locator = By.xpath("//div//h2[@data-qa=\"account-created\"]");
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown checkbox: " + Text);
//        }
//        WebElement visibleText = driver.findElement(locator);
//        Thread.sleep(3000);
//        if (visibleText.isDisplayed()) {
//            Assert.assertEquals(visibleText.getText(), Text);
//        }
//
//
//    }

//    public void handleAds() {
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'aswift_')]")));
//        driver.findElement(By.id("dismiss-button")).click(); //Close Ad
//        driver.switchTo().defaultContent();
//    }
        public void removeAdByJS(WebElement adElementId) {
        try {

            ((JavascriptExecutor) driver).executeScript("document.getElementById('" + adElementId + "').remove();");
        } catch (Exception e) {
            System.out.println("Failed to remove ad using JavaScript.");
        }
}

}

