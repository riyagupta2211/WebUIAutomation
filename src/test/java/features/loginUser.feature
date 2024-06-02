Feature: Login User functionality

  @correctlogin
  Scenario: To verify user is logged in with correct email and password
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click on Signup/Login button
    Then Verify "Login to your account" is visible
    When I enter correct email_address "rgupta67@gmail.com" and password "abc123@"
    And I click "Login" button
    Then Verify that "Logged in as Riya" with "LoggedInAsXpath" is visible
#    When I Click "/delete_account" link button
#    Then Verify that "ACCOUNT DELETED!" with xpath "AccountDeletedXpath" is visible
#
@incorrectlogin
  Scenario: To verify user is logged in with incorrect email and password or not
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click on Signup/Login button
    Then Verify "Login to your account" is visible
    When I enter correct email_address "rgupta11@gmail.com" and password "abc123@"
    And I click "Login" button
    Then Verify error "Your email or password is incorrect!" is visible

    @logout
  Scenario: To verify logout user functionality
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click on Signup/Login button
    Then Verify "Login to your account" is visible
    When I enter correct email_address "rgupta67@gmail.com" and password "abc123@"
    And I click "Login" button
    Then Verify that "Logged in as Riya" with "LoggedInAsXpath" is visible
    When I Click "/logout" link button
    Then Verify that user is navigated to login page with "LoginSignUpPageTitle"
