Feature: Look up a company's stock quote

Background:
    Given url baseUrl
    
Scenario: Searching for google
    Given path '/search/GOOGL'
    When method GET
    Then status 200