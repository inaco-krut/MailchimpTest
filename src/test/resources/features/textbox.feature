Feature: textbox

  Scenario Outline: Create a user
    Given I have started browser "<browser>"
    Given I write random email "<UsrEmail>"
    Given I write random name "<UsrName>"
    Given I write random password "<password>"
    When I click on submit
    Then I Quit Test

    Examples:
      | browser | UsrName | UsrEmail | password |
      | edge    | randomName | fredrik@mail.com | Qwerty@123 |
      | edge    | randomUsed | fredrik@mail.com | Qwerty@123 |
      | edge    | randomManyChars | fredrik@mail.com | Qwerty@123 |
      | edge    | userNameMissingEmail |  | Qwerty@123 |



