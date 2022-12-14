#Author: Mohammad Shokriyan

@Regression
Feature: Accounts Sections Feature

	Background: Login to CSR Portal with supervisor credential
		When user enter username "supervisor" and password "tek_supervisor"
    When user click on login button
    And wait 2 second
    Then Login page title is "Tek Insurance App"

  @Account_table @Regression
  Scenario: Testing default pagination on the table. 
  	When user click on accounts Link
  	And wait 6 second
  	Then number of rows in account table should be 10
 