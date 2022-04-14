Feature: textbox

  Scenario Outline: Create a user
    Given I have started browser "<browser>"
    Given I write random email "<email>"
    Given I write a name "<userName>"
    Given I write a password "<password>"
    When I click on submit
    Given I check asserts "<asserts>"
    Then I Quit Test

    Examples:
      | browser | userName             | email            | password   |  asserts |
      | chrome  | randomName           | random           | Hunter$$ |  checkEmail |
      | edge    | manyChars            | random           | Hunter$$ |  longText |
      | chrome  | randomUsed           | random           | Hunter$$ |  textUsed |
      | edge    | missingEmail         |                  | Hunter$$ |  textMissing |



