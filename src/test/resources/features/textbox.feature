Feature: textbox

  Scenario Outline: Create a user
    Given I have started browser "<browser>"
    Given I write random email "<email>"
    Given I write random name "<userName>"
    Given I write random password "<password>"
    When I click on submit
    Then I Quit Test

    Examples:
      | browser | userName             | email            | password   |
      | chrome  | randomName           | random@mail.com  | Qwerty@123 |
      | edge    | randomUsed           | fredrik@mail.com | Qwerty@123 |
      | chrome  | ManyChars            | fredrik@mail.com | Qwerty@123 |
      | edge    | userNameMissingEmail |                  | Qwerty@123 |



