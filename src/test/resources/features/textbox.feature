Feature: textbox

  Scenario Outline: Create a user
    Given I have started browser "<browser>"
    Given I write random email "<UsrEmail>"
    Given I write random name "<UsrName>"
    Given I write random password "<password>"
    When I click on submit
    Then I verify the email Address

    Examples:
      | browser | UsrName | UsrEmail | password |
      | chrome    |  |  |  |