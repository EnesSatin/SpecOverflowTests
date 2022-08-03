# User Story: As a user, I should be able register on the system.

Feature: Registration

  Background:
    Given the user navigates to the home page
    When the user clicks on the register page


  Rule: Password must be at least 4 characters long

    Scenario: Should be able to register with password which must be at least 4 characters long
      And the user attempts to register with user name "Michael" and password "0987"
      And the user clicks on the register button
      Then the registration should be successful


  Rule: Registration data should be valid

    Scenario: Should be able to register with valid credentials
      And the user completes the registration process
      Then the user is ready to login
