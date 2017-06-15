Feature: Sign up to BestPlaces

  As a user
  I want to sign up to BestPlaces
  so that I have an account

  Scenario: Registration
    Given I am on the "Welcome" Page
    When I press the button "Register now"
    And I see the registration form
    And I enter "Maximilian" in the input field "first name"
    And I enter "Mustermann" in the input field "last name"
    And I enter "Karlsruhe" in the input field "hometown"
    And I enter "Max" in the input field "username"
    And I enter "1234" in the input field "password"
    And I enter "1234" in the input field "cornfirm password"
    And I click on the button "Register"
    Then I should see the "Success Message"
  Scenario: Registration with wrong confirm password
    Given I am on the "Welcome" Page
    When I press the button "Register now"
    And I see the registration form
    And I enter "Maximilian" in the input field "first name"
    And I enter "Mustermann" in the input field "last name"
    And I enter "Karlsruhe" in the input field "hometown"
    And I enter "Max" in the input field "username"
    And I enter "1234" in the input field "password"
    And I enter "1235" in the input field "cornfirm password"
    Then I should see an error message "password not equal"
    And I should enter the password again
  Scenario: Registration with username already exists
    Given I am on the "Welcome" Page
    When I press the button "Register now"
    And I see the registration form
    And I enter "Maximilian" in the input field "first name"
    And I enter "Mustermann" in the input field "last name"
    And I enter "Karlsruhe" in the input field "hometown"
    And I enter "Max" in the input field "username"
    Then I should see an error message "username already exists"
    And I should enter "Max1"




