package pageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ContactUsPage {
    WebDriver driver;
    Properties constants = new Properties();
    String buttonXpath;
    String PathFile;

    public ContactUsPage(WebDriver driver) throws IOException {
        this.driver = driver;
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Constants.properties");
        constants.load(in);
    }
    By name = By.xpath("//input[@data-qa=\"name\"]");
    By email = By.xpath("//input[@data-qa=\"email\"]");
    By subject = By.xpath("//input[@data-qa=\"subject\"]");
    By message = By.xpath("//textarea[@data-qa=\"message\"]");


    public void enterContactUsFormDetails(DataTable dataTable) {

    List<Map<String,String>> contactDetails = dataTable.asMaps(String.class,String.class);
    for (Map<String, String> map : contactDetails) {
        WebElement name_contactUs = driver.findElement(name);
        WebElement email_contactUs = driver.findElement(email);
        WebElement subject_contactUs = driver.findElement(subject);
        WebElement message_contactUs = driver.findElement(message);

        name_contactUs.sendKeys(map.get("Name"));
        email_contactUs.sendKeys(map.get("Email"));
        subject_contactUs.sendKeys(map.get("Subject"));
        message_contactUs.sendKeys(map.get("Message"));
    }

    }
    public void clickButtonWithXpath(String xpath) {

        buttonXpath = constants.getProperty(xpath);
        WebElement button = driver.findElement(By.xpath(buttonXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);

    }
    public void uploadFile(String xpath, String filePath){

        PathFile = constants.getProperty(filePath);
        driver.findElement(By.xpath())
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
