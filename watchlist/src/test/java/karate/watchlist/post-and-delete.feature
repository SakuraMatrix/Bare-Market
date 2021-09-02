Feature: Adding and removing a stock from watchlist

Background:
    Given url baseUrl
    Given path '/watchlists'
    
Scenario: Add GOOGL to watchlist

    And header Accept = 'application/json'
    And request { watchlistKey: { id: 1, symbol: 'GOOGL'} }
    When method POST
    Then status 200

Scenario: Removing GOOGL from watchlist
    Given path '/GOOGL'
    When method DELETE
    Then status 200