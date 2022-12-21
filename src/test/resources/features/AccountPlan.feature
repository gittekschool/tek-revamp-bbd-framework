#Author: your.email@your.domain.com
@tag
Feature: Account Plan Feature

  Background: 
    When user enter username "supervisor" and password "tek_supervisor"
    When user click on login button
    And wait 2 second

  @Account_plan
  Scenario: Validate A primary person have Plans
    When user click on accounts Link
    And wait 10 second
    When user filter by email that have account plan
    And wait 2 second
    When user click on first row detail link
    And wait 2 second
    When user click on view plans button
   	Then all Plans Cost should be as Expected 
