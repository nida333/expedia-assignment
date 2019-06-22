Feature: Home Page
  Homepage - Visual test of all items on homepage (E2E scenario)

  @testcase:1
  Scenario Outline: Verify the logo is displayed on the home page
    Given the user is on the 'Home' page
    And search form is displayed
    And destination search field is displayed with label as '<destinationLabel>'
    And check in date field is displayed with label as '<checkinLabel>'
    And checkout date field is displayed with label as '<checkoutLabel>'
    When user enters destination '<destination>'
    And user selects checkin date from '<months>' months from now
    And user selects checkout date as '<nights>' nights from checkin date
    And tap on search button
    Then hotel listing page is displayed

    Examples:
      | destinationLabel                                | checkinLabel | checkoutLabel | destination | months | nights |
      | Destinations and properties around the world... | Check in     | Check out     | London      | 3      | 3      |

  Scenario: User has successfully landed to hotel listing page
    Given hotel listing page is displayed
    And view on map button is also displayed
    When user taps on view on map button
    Then map view is displayed

  Scenario Outline: Verify user can see the hotels on the map
    Given map view is displayed
    And button '<btnLabel>' to zoom in to see the properties is also displayed
    When user taps on it
    Then hotel pins are displayed

    Examples:
      | btnLabel                             |
      | Please zoom in to see the properties |


  Scenario: Verify user can expand legend filter tab
    Given hotel pins are displayed
    And legend filter tab is displayed
    When user expands legend filter tab
    Then availability legend filters are displayed

  Scenario: User can select the green pin to open a property card
    Given availability legend filters are displayed
    And user unchecks the unavaible legend filter
    And user unchecks the doesn't match your criteria legend filter
    When user taps on green pin
    Then property card is displayed
    And not available <message> is not displayed on property card


  Scenario: User taps on property card then room listing page is displayed
    Given property card is displayed
    When user taps on property card
    Then room listing page is displayed


  Scenario: Verify the hotels name and price displayed on property card is same as displayed on room listing page
    Given room listing page is displayed
    When user views the hotel's name
    And user views the room price
    Then hotel's name is same as displayed on property card on map view page
    And price is same as displayed on propert card on map view page