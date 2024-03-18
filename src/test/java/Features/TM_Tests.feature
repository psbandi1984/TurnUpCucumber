Feature: This Test Suite contains test scenarios for Time and Material page

  Scenario: A. Create a new Time and Material record with alpha code
    Given I log into Turnup portal
    When I navigate to Time and Material page
    And I create a new Time and Material record 'Time1' 'TimeCode' '50'
    Then the record should be saved 'Time1' 'TimeCode' '50'

  Scenario Outline: B. Edit an existing Time and Material record
    Given I log into Turnup portal
    When I navigate to Time and Material page
    And I edit an existing Time and Material record <newCode> <newDescription> <newPrice>
    Then the record should be updated <newCode> <newDescription> <newPrice>

    Examples:
      | newCode | newDescription    | newPrice |
      | 'Time2' | 'TimeCodeEdited'  | '30'     |
      | 'Time3' | 'Time'            | '40'     |


  Scenario: C. Delete an existing Time and Material record
    Given I log into Turnup portal
    When I navigate to Time and Material page
    And I delete an existing Time and Material record 'Time3'
    Then the record should be deleted 'Time3'