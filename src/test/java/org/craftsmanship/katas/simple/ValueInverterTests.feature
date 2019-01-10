Feature: Implement a Value converter for boolean, numbers and colors
  Scenario: Test with boolean
    Given I pass values to the SUT
    When I pass
      | value |
      | false |
      | true  |
    Then I should obtain
      | expected |
      | true     |
      | false    |