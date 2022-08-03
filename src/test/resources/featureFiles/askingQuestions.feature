# User Story: As a user, I should be able to ask questions.

@wip
Feature: Asking Questions

  Background:
    Given the user is on the home page


  Rule:  Only authenticated users can ask questions

    Scenario: Should be able to ask questions only by authenticated users
      When the user clicks on Ask Question section
      And the user fills out the required fields
      Then the user needs to be logged in

  Rule: The asked question should be valid (mandatory, etc.)

    Scenario: Should be able to complete mandatory fields by asking question
      When the user clicks on default login section
      And the user clicks on Ask Question section
      And the user does not complete the required fields in the asking question section
      Then the user needs to fill out mandatory fields


