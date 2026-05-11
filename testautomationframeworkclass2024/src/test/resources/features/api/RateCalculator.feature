@api
Feature: Get a rate
  Scenario: Verify that a user can get a correct rate
    Given that a user makes a Get request to get rate
    Then i should get a 200 status code
    Then i should be able to get a correct rate
      | rate | fromCurrency | toCurrency |
      | 1050 | GBP          | NGN        |

  Scenario: Verify that a user can set a correct rate
    Given that a user make a Post request to set rate
      | rate | fromCurrency | toCurrency |
      | 1050 | GBP          | NGN        |
    Then the response message should be "Rate changed successfully!"

