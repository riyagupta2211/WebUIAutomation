Feature: Contact Us Form
  Scenario: To verify Contact Us from functionality
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click "/contact_us" link button
    Then Verify that "GET IN TOUCH" with xpath "getInTouchXpath" is visible
    When I enter contact us form details
    | Name | Email | Subject | Message |
    | Riya | rgupta67@gmail.com | Regarding product details!! | Hi, I want to know about latest product details |
    And I upload a file with "FilePathXpath" and "FilePath"
    And I click on Submit button with "submitButtonXpath"
    And I click on "OK" button in popup
    Then Verify that "Success! Your details have been submitted successfully." with xpath "successMessage" is visible
    When I Click " Home" button
    Then Verify that home page is visible successfully



