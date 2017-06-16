Feature: Sign up to BestPlaces

  As a user
  I want to sign up to BestPlaces
  so that I have an account

  Scenario: Registration
    Given I can see the "Welcome" Page
    When I press the "Register now"-Button
    And I can see the "Registration" form
    And I type "Maximilian" in the "first name"-field
    And I type "Mustermann" in the "last name"-field
    And I type "Karlsruhe" in the "hometown"-field
    And I type "Max" in the "username"-field
    And I type "1234" in the "password"-field
    And I type "1234" in the "cornfirm password"-field
    And I press the "Register"-Button
    Then I can see the "Success"-Message
  Scenario: Registration with wrong confirm password
    Given I can see the "Welcome" Page
    When I press the "Register now"-Button
    And I see the "registration" form
    And I type "Maximilian" in the "first name"-field
    And I type "Mustermann" in the "last name"-field
    And I type "Karlsruhe" in the "hometown"-field
    And I type "Max" in the "username"-field
    And I type "1234" in the "password"-field
    And I type "1235" in the "cornfirm password"-field
    Then I can see "password not equal"
    And I see the "registration" form
  Scenario: Registration with username already exists
    Given I can see the "Welcome" Page
    When I press the "Register now"-Button
    And I see the "registration" form
    And I type "Maximilian" in the "first name"-field
    And I type "Mustermann" in the "last name"-field
    And I type "Karlsruhe" in the "hometown"-field
    And I type "Max" in the "username"-field
    Then I can see "username already exists"




