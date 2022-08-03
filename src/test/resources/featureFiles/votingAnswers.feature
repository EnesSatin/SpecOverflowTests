# User Story: As a user, I should be able to vote answers.

Feature: Voting answers

  Rule:  Only authenticated users can vote

    Scenario: Should only be able to vote by authenticated users
      Given the user is on the Questions section
      When the user clicks on the first question
      And the user clicks on the vote down button
      Then the pop-up message is shown

  Rule: Answer should move up/down right after voting if the vote changes the order

    Scenario: Should be able to change the order of the answers after voting
      Given the user is on the home page
      When the user clicks on default login section
      And the user clicks on the question that has been answered
      Then the user verifies that the second answer should move up after clicking up


