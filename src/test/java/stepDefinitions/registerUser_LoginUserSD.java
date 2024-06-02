package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginSignUpPage;
import utils.TestContextSetup;

import java.io.IOException;

public class registerUser_LoginUserSD {

    TestContextSetup testContextSetup;
    public registerUser_LoginUserSD(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @Given("the browser is launched")
    public void the_browser_is_launched() {
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

    }
    @When("I navigate to url {string}")
    public void i_navigate_to_url(String string) {
//        driver.get("https://automationexercise.com/");
//        driver.manage().window().maximize();
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {

        HomePage hp = testContextSetup.pageObjectManager.getHomePage();
        boolean flag = hp.loginSignUpIsVisible();
        Assert.assertTrue(flag);

    }

    @When("I Click on Signup\\/Login button")
    public void iClickOnSignupLoginButton() {
        HomePage hp = testContextSetup.pageObjectManager.getHomePage();
        hp.clickLoginSignUp();
    }

    @Then("Verify {string} is visible")
    public void verify_is_visible(String signUpText) throws IOException {
        LoginSignUpPage lp = testContextSetup.pageObjectManager.getLoginSignUpPage();
        String signUpTextCheck = lp.loginSignUpTextIsVisible(signUpText);
        Assert.assertEquals(signUpTextCheck,signUpText);
    }
    @When("I enter name {string} and email address {string}")
    public void i_enter_name_and_email_address(String nameforSignUp, String emailForSignUp) throws InterruptedException, IOException {
        LoginSignUpPage lp = testContextSetup.pageObjectManager.getLoginSignUpPage();
        lp.signUpDetails(nameforSignUp,emailForSignUp);

    }
    @When("I click on Signup button")
    public void i_click_on_button() throws IOException {
        LoginSignUpPage ls = testContextSetup.pageObjectManager.getLoginSignUpPage();
        ls.clickSignUpButton();
    }

    @Then("Verify that {string} with xpath {string} is visible")
    public void verifyThatWithXpathIsVisible(String text, String xpath) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.verifyTextVisibilityWithXpath(text,xpath);
    }

    @When("I fill account details")
    public void i_fill_account_details(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.FillInAccountDetailsWith(dataTable);
    }

    @When("Select checkbox {string}")
    public void selectCheckboxWithXpath(String checkboxText) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.selectCheckboxWithIdentifier(checkboxText);
    }
    @When("I fill in the address details")
    public void i_fill_in_the_address_details(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {

        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.fillInAddressDetails(dataTable);
    }
    @When("I Click {string} button")
    public void i_click(String buttonText) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.clickOnButton(buttonText);
    }
    @When("I Click {string} link button")
    public void iClickLinkButton(String text) throws IOException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.clickOnLinkButton(text);
    }
    @Then("Verify that {string} with {string} is visible")
    public void verifyThatWithAndIsVisible(String loggedIn, String LoggedInAsXpath) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.verifyMultipleTextVisibilityWithMultipleXpath(loggedIn,LoggedInAsXpath);
    }
    @Then("I click {string} button")
    public void iClickButton(String buttonText) throws IOException, InterruptedException {
        LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
        lp.clickOnButton(buttonText);
    }

    @When("I enter correct email_address {string} and password {string}")
    public void iEnterCorrectEmail_addressAndPassword(String email_address, String password) throws InterruptedException, IOException {
        LoginSignUpPage lp = testContextSetup.pageObjectManager.getLoginSignUpPage();
        lp.loginDetails(email_address,password);
    }

    @Then("Verify error {string} is visible")
    public void verifyErrorIsVisible(String errorMessage) throws IOException {
        LoginSignUpPage lp = testContextSetup.pageObjectManager.getLoginSignUpPage();
        lp.errorMessageVisibilityCheck(errorMessage);


    }

    @Then("Verify that user is navigated to login page with {string}")
    public void verifyThatUserIsNavigatedToLoginPage(String title) throws IOException {
        LoginSignUpPage lp = testContextSetup.pageObjectManager.getLoginSignUpPage();
        lp.userNavigationToLoginSignUpPage(title);
    }
}
