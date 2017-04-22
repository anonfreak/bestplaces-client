Feature: Manage Visits

  As a user
  I want to manage my visits
  so that I can list and edit the places I have been

  Scenario: List favorites
    Given I am in the "Timeline"
    And see the last 10 visits
    When I press the Button "Map"
    Then I should see the "Visit Map"
  Scenario: Delete favorite
    Given I am in the "Timeline"
    When I select a Visit
    And I see the "Visit View"
    And I press the button "Delete"
    Then I should be in the "Timeline" again
    And I shouldn't see the Visit in the "Timeline" anymore
  Scenario: View Place
    Given I am in the "Timeline"
    When I click a Visit
    Then I should see information page this visit
  Scenario: Edit Visit
    Given I am in the "Visit View"
    And I click the "Edit" Button
    And I see the "Edit View"
    And I change the amount of spend money
    And I press the button "Save"
    Then I should see a "succes notification"
    And my changes should been saved
    And I should get navigated to the "Timeline"

