Feature: Open a web browser

  Scenario: Kraft Login Test
    Given The user is on the Kraft login page
    When The user enters in following credentials
      | email    | arvadas@gmail.com |
      | password | 12345     |
    Then The user should be able to see own name : "Ahmet" at the dashboard page
    And The user closes browser