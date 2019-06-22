Feature: Hotel Search

  @testcase:1
  Scenario Outline: Hotel search form is displayed on the homepage
    Given the user opens 'Home' page
    And the user is on the 'Home' page
    Then search form is displayed
    And destination search field has label '<destinationLabel>'
    And check in date field has label '<checkinLabel>'
    And checkout date field has label '<checkoutLabel>'
    And submit search button has text '<searchButtonText>'

    Examples:
      | destinationLabel                                | checkinLabel | checkoutLabel | searchButtonText |
      | Destinations and properties around the world... | Check in     | Check out     | Search           |


  @testcase:2
  Scenario Outline: Number of nights should be updated when the date is changed on the form
    Given the user opens 'Home' page
    And the user is on the 'Home' page
    And search form is displayed
    When user selects checkin date '<months>' months from now and checkout date '<days>' days from checkin date
    Then number of nights should be '<days>'

    Examples:
      | months | days |
      | 3      | 3    |



  @testcase:3
  Scenario Outline: Hotel listing page is displayed when valid date and destination is submitted from homepage
    Given the user opens 'Home' page
    And the user is on the 'Home' page
    And search form is displayed
    When user enters destination '<destination>'
    And user selects checkin date '<months>' months from now and checkout date '<nights>' days from checkin date
    And user clicks on search button
    Then the user is on the 'Hotel list' page
    And hotel listing page is displayed
    And hotel list is displayed

    Examples:
      | destination | months | nights |
      | London      | 3      | 3      |


  @testcase: 4
  Scenario Outline: Hotel details on the listing page should match the hotel details page
    Given the user opens 'Home' page
    And the user is on the 'Home' page
    And the user performed a hotel search to '<destination>' from '<months>' for '<nights>'
    And the user is on the 'Hotel list' page
    And hotel listing page is displayed
    And hotel list is displayed
    When the user selects a hotel from the list
    Then the user is on the 'Hotel Details' page
    And the hotel details is same as the listing page

    Examples:
      | destination | months | nights |
      | London      | 3      | 3      |