Feature: Add Visit in Place View

  As a user
  I want to add a visit for a specific place on a specific date

  Scenario: Add Visit
    Given I am signed up
    And I am logged in
    When I press the "Search"-Button
    And I type "Pizza" in the "Search Bar"
    And I select "Pizza Max"
    And I press the "Calendar"-Button
    And I type "10/04/2017" in the "Date"-field
    And I type "10:00" in the "Time"-field
    And I press the "Add"-Button
    And I press the "Timeline"-Button
    Then I should see "Pizza Max" in the TImeline