#Author: Mohammad Shokriyan
@Login_Test
Feature: Security Test for login

  @Smoke @Regression
  Scenario: happy path login with valid username and valid password.
    When user enter username "supervisor" and password "tek_supervisor"
    When user click on login button
    And wait 2 second
    Then Login page title is "Tek Insurance App"
    And wait 2 second
    Then validate user profile name to be "Supervisor"

  @Regression @Smoke
  Scenario Outline: Negative login scenarios
    When user enter username "<username>" and password "<password>"
    When user click on login button
    And wait 2 second
    Then validate banner message to be "<expectedMessage>"

    Examples: 
      | username    | password       | expectedMessage      |
      | supervisor1 | tek_supervisor | User not found       |
      | supervisor  | tek-supervisor | Password Not Matched |
      | admin       | admin          | User not found       |
@Regression	@Adhoc
  Scenario: Test for Login button be disable without username and password.
    When user enter username "" and password ""
    Then login button should be disabled.
