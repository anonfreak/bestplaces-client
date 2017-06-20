Feature: Searching

  As a user
  I want to search for places by providing name and location

  Scenario: specific location
    Given I am signed up
    And I am logged in
    And I navigate to the "Search"
    When I type "Pizza" in "Search"-field
    And I type "Berlin" in "Location"-field
    And I press the "Search"-Button
    Then I should see "Search results" for "Pizza" in "Berlin"




