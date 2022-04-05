Feature: Google search

  Scenario Outline: Validate consult results are greater than zero
    Given user navigates to URL "<URL>"
    When user searches with specific keyword "<keyword>"
    Then user verifies results are greater than zero

    Examples: 
      | URL                       | keyword  |
      | https://www.google.com.co | Simetrik |
