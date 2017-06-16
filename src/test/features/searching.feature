Feature: Searching

  As a user
  I want to search for places by providing name and location

  Scenario: near current location
    Given I am signed up
    And I am logged in
    And I navigate to the "Timeline" Page
    When I type "Pizza" in "search bar"
    And I press
    And I press the "Search"-Button
    Then I should see "Pizza Max"
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




