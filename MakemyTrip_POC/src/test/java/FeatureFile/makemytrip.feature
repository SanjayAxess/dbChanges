Feature: Bus Ticket Booking on MakeMyTrip

  Scenario: Find and Reserve the Cheapest Available Bus Ticket
    Given I am on the MakeMyTrip homepage
    When I navigate to the Bus booking section
    And I enter "Chennai" as the pickup location and "Bangalore" as the drop location
    And I select a travel date
    And I search for available buses
    Then the bus search results page should be displayed
    When I filter the bus results to find the cheapest bus
    And I select the cheapest bus available
    And I select Pickup as "Koyambedu" & Drop Points as "Electronic City"
    And I click to select a seat
    And I reserve a berth seat
    And I proceed to continue
    And I enter valid traveller details
    Then I should be navigated to the payment page

