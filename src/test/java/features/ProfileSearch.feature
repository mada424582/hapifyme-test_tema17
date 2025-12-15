@regression
Feature: Searching profile functionality
  Scenario Outline: User searches and opens a profile
    Given user is already logged into app
    When user searches for "<username>"
    Then the profile for "<username>" is displayed

    Examples:
      |username             |
      |George Datcu         |
      |Andreea Smarandache  |
