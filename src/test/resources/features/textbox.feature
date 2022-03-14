Feature: textbox

  Scenario Outline: add Simple information
    Given I have started "<browser>" browser
    Given I have written my name "<name>"
    Given I have written my email "<email>"
    Given I have written my current address "<current>"
    Given I have written my permanent address "<permanent>"
    When I click on submit
    Then my contact information is displayed

    Examples:
      |browser|name|email|current|permanent|
      |edge|Fredrik|fredrik@hotmail.com|Goteborg|Jorden|
      |chrome|Johan|Johan@hotmail.com|Stockholm|Mars|
      |edge|Lars|Lasse@hotmail.com|Harjunga|Jupiter|
      |chrome|Nisse|NisseOlsson@hotmail.com|Partille|Venus|