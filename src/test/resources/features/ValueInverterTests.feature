Feature: Implement a Value converter for boolean, numbers and colors
  Scenario: Test with boolean
    Given I start the system
    When I pass
      | value |
      | false |
      | true  |
    Then I should obtain
      | expected |
      | true     |
      | false    |