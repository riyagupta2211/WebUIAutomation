package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.ContactUsPage;
import utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class contactUsSD {

    TestContextSetup testContextSetup;
    public contactUsSD(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("I enter contact us form details")
    public void i_enter_contact_us_form_details(DataTable dataTable) throws IOException {
        ContactUsPage cp = testContextSetup.pageObjectManager.getContactUsPage();
        cp.enterContactUsFormDetails(dataTable);
    }
    @When("I upload a file with {string} and {string}")
    public void i_upload_a_file(String xpath, String filePath) throws IOException {
        ContactUsPage cp = testContextSetup.pageObjectManager.getContactUsPage();
        cp.uploadFile(xpath,filePath);

    }
    @When("I click on {string} button in popup")
    public void i_click_on_button_in_popup(String submitButtonText) throws IOException {

        ContactUsPage cp = testContextSetup.pageObjectManager.getContactUsPage();
        cp.acceptAlert();


    }
    @And("I click on Submit button with {string}")
    public void iClickOnSubmitButtonWith(String submitButtonXpath) throws IOException {
        ContactUsPage cp = testContextSetup.pageObjectManager.getContactUsPage();
        cp.clickButtonWithXpath(submitButtonXpath);

    }


}
