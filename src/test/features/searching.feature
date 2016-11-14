Feature: Searching

  As a user
  I want to search for places by providing name and location

  Scenario: near current location
    Given I pressed the "Search Bar"
    And The current location is "Karlsruhe"
    When I enter "Pizza" in search bar
    And I press "Search"
    Then I should see "Search results" for "Pizza" in "Karlsruhe"
  Scenario: specifiy location
    Given I pressed the "Search Bar"
    When I press on the "Navigator symbol"
    And I see "Location PopUp"
    And I enter "Berlin" in location input field
    And I enter "Pizza" in search bar
    And I press "Search"
    Then I should see "Search results" for "Pizza" in "Berlin"
  Scenario: go back
    Given I am in Search View
    When I press "Back"
    Then I should see the "Timeline"




