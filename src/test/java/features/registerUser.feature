Feature: Register User
  Scenario: To register user on automation exercise website
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click on Signup/Login button
    Then Verify "New User Signup!" is visible
    When I enter name "Riya" and email address "rgupta83@gmail.com"
    And I click on Signup button
    Then Verify that "ENTER ACCOUNT INFORMATION" with xpath "AccountInfoXpath" is visible
    When I fill account details
      | title | name  | Password | Date of birth |
      | Mr | Riya | gupta123 | 4/4/1992 |
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And I fill in the address details
      | First name | Last name | Company | Address | Address2 | Country | State | City | Zipcode | Mobile Number |
      | Riya | jain | Bajaj and sons pvt. ltd. | F-99,Block B, bhajanpura | Near laxmi nagar metro | India | Uttar pradesh | lucknow | 209001  |9933827382 |
    When I Click "Create Account" button
    Then Verify that "ACCOUNT CREATED!" with xpath "AccountCreatedXpath" is visible
    When I Click "Continue" button
    Then Verify that "Logged in as Riya" with "LoggedInAsXpath" is visible
    When I Click "/delete_account" link button
    Then Verify that "ACCOUNT DELETED!" with xpath "AccountDeletedXpath" is visible
    And I click "Continue" button

  Scenario: To register user with existing email
    Given the browser is launched
    When I navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When I Click on Signup/Login button
    Then Verify "New User Signup!" is visible
    When I enter name "Riya" and email address "rgupta67@gmail.com"
    And I click on Signup button
    Then Verify error "Email Address already exist!" is visible







