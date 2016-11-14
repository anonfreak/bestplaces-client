Feature: Manage Favorites

  As a user
  I want to manage my favorite places
  so that I can list and edit the most important places for me at one sight

  Scenario: List favorites
    Given I am in the "Home view"
    When I press the Button "Favorites"
    Then I should see the "Favorite view"
  Scenario: Add new favorite
    Given I am in the "Favorite view"
    When I press the "+"
    And I see in a new view all visits from my "Timeline"
    And I choose one visit
    And I press its "heart-symbol"
    Then I should see the "Favorite view" again
    And the place should be seen in this view
    And the place should have a "filled-in heart-symbol"
  Scenario: Delete favorite
    Given I am in the "Favorite view"
    When I press a "filled-in heart-symbol" of one visit
    And I see the confirm question "Sure to delete?"
    And I pressed "Yes"
    Then it should be removed from the "Favorite view"
    But stay in the Timeline as visit
    And get in the Timeline a "non-filled heart-symbol" again
  Scenario: View Place
    Given I am in the "Favorite View"
    When I click a favorite
    Then I should see the place and all corresponding placeinformation
  Scenario: Edit Place
    Given I am in the "Place view"
    When I press the "edit button"
    And change or add some information
    And press the "save button"
    Then all chances should be saved
    And the new information should be shown