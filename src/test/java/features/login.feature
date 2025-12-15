@regression
Feature: Login functionality
  Scenario Outline: Successful Login
    Given user is on the login page
    When user logins with "<email>" and "<password>"
    Then user is redirected to the new page

    Examples:
    |email                           | password         |
    |madalina.munteanu424@gmail.com  | Accidentat!_2025 |

    Scenario Outline: Login fails with invalid credentials
      Given user is on the login page
      When user logins with "<email>" and "<password>"
      Then an error message is displayed

      Examples:
      |email          |password|
      |sss@bbb.com    |aaaaaaa|
      |ddddd@dddd.com |bbbbbb|

      # Scenario with DataTable
  Scenario: Login with multiple user in one run
    Given user is on the login page
    When user enters the following credentials
      |email           |password|
      |user1@aaaa.com   |duddddddd|
      |user2@bbbb.com    |bbbbbbbbb|

    Then user sees results accordingly