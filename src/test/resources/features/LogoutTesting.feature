#Author: Mohammad Shokriyan
@Regression
Feature: Security Feature

  @Logout @Smoke
  Scenario: Login with CSR account and Logout
    When user enter username "supervisor" and password "tek_supervisor"
    When user click on login button
    And wait 2 second
    Then Login page title is "Tek Insurance App"
    And wait 2 second
    Then validate user profile name to be "Supervisor"
    When user logout
    And wait 2 second
    Then Login page title is "TEK Insurance Portal"
    Then Loaded Section is "Customer Service Portal"
