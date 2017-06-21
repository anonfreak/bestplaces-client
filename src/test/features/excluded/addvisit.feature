@ignore
Feature: Add Visit in Place View

  As a user
  I want to add a visit for a specific place on a specific date

  Scenario: Add Visit
    Given I am signed up
    And I am logged in
    When I navigate to the "Search"
    And I type "Pizza" in "Search"-field
    And I type "Berlin" in "Location"-field
    And I select "Pizza Max"
    And I press the "Calendar"-Button
    And I type "10/04/2017" in the "Date"-field
    And I type "10:00" in the "Time"-field
    And I press the "Choose"-Button
    Then I navigate to the "Timeline"
    And I can see "Pizza Max"