Feature: Places View for Searching

  As a user
  I want to get Information about a Place

  Scenario: Data is available
    Given I am signed up
    And logged in
    When I press the "Search"-Button
    And I type "Pizza" in the "Search Bar"
    And I select the first result
    Then I see information about the first result