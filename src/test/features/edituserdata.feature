Feature: Edit User Data of BestPlaces Account

  As a User
  I want to chance my user data

  Scenario: Change Something
    Given I am signed up
    And I am logged in
    When I press the "Edit User Data"-Button
    And I see "Edit User view"
    And I type "Durlach" in the "Hometown"-field
    And I press the "Save"-Button
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