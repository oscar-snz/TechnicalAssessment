Feature: Google search

  Scenario Outline: Validate consult results are greater than zero
    Given user navigates to application <region>
    When user searches with specific keyword <keyword>
    Then user verifies search <result>

    @scrum
    Examples: 
      | region  | keyword    | result |
      | "scrum" | "Simetrik" | "0"    |
