Feature: Edit User Data of BestPlaces Account

  As a User
  I want to chance my user data

  Scenario: Change Something
    Given I am signed up
    And loged in
    When I press "Edit User Data" Button
    And I see "Edit User view"
    And I change my hometown from "Kalrsruhe" to "Durlach"
    And I press "Save" Button
    Then I should see a "succes notification"
    And my changes should been saved
    And I should get navigated to the "Timeline"

  Scenario: Change Nothing
    Given I am signed up
    And logged in
    When I press "Edit user data" Button
    And I see "Edit User View"
    And I change nothing
    And I press "Cancel" Button
    Then I should get navigated to the "Timeline"