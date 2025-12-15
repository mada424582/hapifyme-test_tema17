@regression
Feature: Posting a message
  Scenario Outline: Successfully creating a post
    Given user is already logged into app
    When user creates a post with text "<message>"
    Then the post is visible

    Examples:
    |message|
    |testtesttest|
    |prima postare pe azi|
    |blaaaaaaa blaaaa    |