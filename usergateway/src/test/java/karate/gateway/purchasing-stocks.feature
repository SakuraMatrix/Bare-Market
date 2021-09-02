Feature: Purchasing stocks

Background:
    Given url baseUrl

Scenario: Balance is set to 10000

    When path '/balances'
    And header Accept = 'application/json'
    And request { id: 1, balance: 10000 }
    And method PUT
    Then status 200
    
Scenario: Purchase GOOGL is successful

    When path '/holdings'
    And header Accept = 'application/json'
    And request { symbol: 'GOOGL' }
    When method POST
    Then status 200

Scenario: Balance is set to 1000

    When path '/balances'
    And header Accept = 'application/json'
    And request { id: 1, balance: 1000 }
    And method PUT
    Then status 200

Scenario: Purchase does not go through if not enough money is available to purchase stock

    When path '/holdings'
    And header Accept = 'application/json'
    And request { symbol: 'GOOGL' }
    When method POST
    Then status 500