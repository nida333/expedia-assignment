@e2e
Feature: Hotel Map Search

  Scenario Outline: Hotel details on the hotel map page should match the hotel details page
    Given the user opens 'Home' page
    And the user is on the 'Home' page
    And the user performed a hotel search to '<destination>' from '<months>' for '<nights>'
    And the user is on the 'Hotel list' page
    And hotel listing page is displayed
    And hotel list is displayed
    When user taps on view on map button
    And the user is on the 'Hotel Map' page


    Examples:
      | destination | months | nights |
      | London      | 3      | 3      |