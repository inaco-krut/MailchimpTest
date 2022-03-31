Feature: textbox

  Scenario Outline: Create a user
    Given I have started browser "<browser>"
    Given I write random email "<email>"
    Given I write a name "<userName>"
    Given I write a password "<password>"
    When I click on submit
    Then I Quit Test

    Examples:
      | browser | userName             | email            | password   |
      | chrome  | randomName           | random           | random |
      | edge    | ManyChars            | random           | random |
      | chrome  | randomUsed           | random           | random |
      | edge    | userNameMissingEmail |                  | random |



