Feature: Summaries page

Background:
    Given url baseUrl
    Given path '/summaries'
    
Scenario: View summaries page

    When method GET
    Then status 200