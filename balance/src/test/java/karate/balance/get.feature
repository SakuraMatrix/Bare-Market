Feature: Get balance

Background:
    Given url baseUrl
    Given path '/balances'
    
Scenario: Get balance

    When method GET
    Then status 200