@ignore
Feature: Manage Visits

  As a user
  I want to manage my visits
  so that I can list and edit the places I have been

  Scenario: Delete favorite
    Given I am logged in
    And I navigate to the "Timeline"
    When I select "Visit"
    And I see the "Visit View"
    And I press the "Delete"-Button
    Then I can see the "Timeline"
  Scenario: View Place
    Given I am logged in
    And I navigate to the "Timeline"
    When I select "Visit"
    Then I can see the "Visit view"
  Scenario: Edit Visit
    Given I am logged in
    And I navigate to the "Timeline"
    When I select an "Visit"
    And I press the "Edit"-Button
    And I see the "Edit Visit"-Window
    And I type "10" in the "Money"-field
    And I press the "Save"-Button
    Then I can see the "Visit View"

