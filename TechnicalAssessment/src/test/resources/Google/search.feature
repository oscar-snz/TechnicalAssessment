Feature: Google search

  Scenario Outline: Validate consult results are greater than zero
    Given user is on search page "<URL>"
    When user enters keyword "<keyword>"
    Then user verifies results greater than zero

    Examples: 
      | URL                       | keyword  |
      | https://www.google.com.co | Simetrik |
