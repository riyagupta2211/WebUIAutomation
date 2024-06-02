package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver driver;
    public String productName ;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils  = new GenericUtils(testBase.WebDriverManager());
    }
}
