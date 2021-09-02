Feature: Get watchlists

Background:
    Given url baseUrl
    Given path '/watchlists'
    
Scenario: Get watchlists

    When method GET
    Then status 200