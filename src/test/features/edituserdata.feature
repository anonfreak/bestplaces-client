@ignore
Feature: Edit User Data of BestPlaces Account

  As a User
  I want to chance my user data

  Scenario: Change Something
    Given I am signed up
    And I am logged in
    When I navigate to the "Edit User Data" View
    And I type "Durlach" in the "Hometown"-field
    And I type "test" in the "Password"-field
    And I press the "Save"-Button
    Then I should see "Durlach" in "Hometown"