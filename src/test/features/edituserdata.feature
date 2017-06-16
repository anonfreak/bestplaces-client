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
    Then I can see "Succes"

  Scenario: Change Nothing
    Given I am signed up
    And I am logged in
    When I press the "Edit user data"-Button
    And I see "Edit User View"
    And I press the "Cancel"-Button
    Then I can see "Timeline"