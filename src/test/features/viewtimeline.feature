Feature: View the Timeline on BestPlaces

  As a user
  I want to see the Places I have been visited
  so that I get an overview about where I was when

  Scenario: View Timeline
    Given I am signed up
    And Loged in
    When I press in the Dashboard the "Timeline" Button
    Then I should see the "Timeline"

  Scenario: View older Visits
    Given I am in the "Timeline"
    And I can see my ten last "Visits"
    When I scroll
    Then I should see ten more "Visits"