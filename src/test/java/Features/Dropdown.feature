
@Demo_App
Feature: Verifying Functionalities on Views feature on Api Demo App
  @T_01 @sanity_01 @sanity
  Scenario:Select Earth option in Dark Theme drop down
    Given  User launches API Demo App
    And User click on views button
    And User click on Controls button
    When User navigates to Dark Theme dropdown section
    And User selects "Earth"from dropdown
    Then Dropdown selection should be completed

  @T_02
  Scenario:Click Dinner button from  Radio group
    Given  User launches API Demo App
    And User click on views button
    Then User navigates to Radio Group section
    When click on  All of them section
    Then User click on  "Dinner" button


@T_03
  Scenario:Verify Alert handling
    Given  User launches API Demo App
    And User click App option from home page
    And User click on Alert Dialogs
    Then User click on OK button on alert message
    And User click on Alert Dialogs
    Then User click on CANCEL button on alert message

  @T_04
  Scenario:Verify Long press functionality
    Given  User launches API Demo App
    And User click Views option from home page
    And User click on Expandable Lists
    Then User click on Custom Adapter
    And User Perform long press on people Names
    Then Verify context menu

    @T_05
    Scenario:Verify Toast message functionality
      Given  User launches API Demo App
      And User click Views option from home page
      And User click on Expandable Lists
      Then User click on Custom Adapter
      And User Perform long press on people Names
      Then Verify context menu