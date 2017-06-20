Feature: View the Timeline on BestPlaces

  As a user
  I want to see the Places I have been visited
  so that I get an overview about where I was when

  Scenario: View Timeline
    Given I am signed up
    And I am logged in
    When I press the "Timeline"-Button
    Then I see "Timeline"