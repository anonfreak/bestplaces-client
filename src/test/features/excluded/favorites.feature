@ignore
Feature: Manage Favorites

  As a user
  I want to manage my favorite places
  so that I can list and edit the most important places for me at one sight

  Scenario: List favorites
    Given I am in the "Timeline"
    When I press the Button "Favorites"
    Then I should see the "Favorite view"
  Scenario: Add new favorite
    Given I am in the "Favorite view"
    When I press the "+"
    And I see in a new view all visits from my "Timeline"
    And I choose the visit "Pizza Karlsruhe"
    And I press its "heart-symbol"
    Then I should see the "Favorite view" again
    And I should see "Pizza Karlsruhe" in the favorite view
    And The place should have a "filled-in heart-symbol"
  Scenario: Delete favorite
    Given I am in the "Favorite view"
    When I press the "filled-in heart-symbol" of "Pizza Karlsruhe"
    And I see the confirm question "Sure to delete?"
    And I pressed "Yes"
    Then I shouldn't see "Pizza Karlsruhe" in the "Favorite view" anymore
    But I should see "Pizza Karlsruhe" in the "Timeline"
    And I should see a "not-filled heart-symbol" for "Pizza Karlsruhe"
  Scenario: View Place
    Given I am in the "Favorite View"
    When I click "Pizza Karlsruhe"
    Then I should see information page of "Pizza Karlsruhe"