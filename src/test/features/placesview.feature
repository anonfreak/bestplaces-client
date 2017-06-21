Feature: Places View for Searching

  As a user
  I want to get Information about a Place

  Scenario: Data is available
    Given I am signed up
    And I am logged in
    When I press the "Search"-Button
    And I type "Pizza" in "Search"-field
    And I type "Berlin" in "Location"-field
    And I select the "first" result
    Then I see information about the first result

  Scenario: Go back
    Given I am signed up
    And I am logged in
    When I press the "Search"-Button
    And I type "Pizza" in "Search"-field
    And I type "Berlin" in "Location"-field
    And I select the "first" result
    And I press the "Back"-Button
    Then I should see the search results for "pizza" again