Feature: Calculator Test

  Scenario: Sum of several numbers
    Given The user is on the start page
    When The user sums of following numbers
    |3|
    |4|
    |5|
    Then The result should be 12