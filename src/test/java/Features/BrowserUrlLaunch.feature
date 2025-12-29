Feature: Launch
  @T_01
  Scenario:Select Earth option in Dark Theme drop down
    Given  User launches API Demo App
    When User navigates to Dark Theme dropdown section
    And User selects "Earth"from dropdown
    Then Dropdown selection should be completed