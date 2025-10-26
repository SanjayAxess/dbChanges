Feature: Bus Ticket Booking on MakeMyTrip End to End Testing

  Scenario Outline: Find and Reserve the Cheapest Available Bus Ticket
    Given I am on the MakeMyTrip homepage
    When I navigate to the Bus booking section
    And I enter "<FromCity>" as the pickup location and "<To-City>" as the drop location
    And I select a travel date
    And I search for available buses
    Examples:
      | FromCity  |  To-City  |
      | Chennai   | Bangalore |

  Scenario Outline: Search for cheapest Bus and reserve a berth seat
    Then the bus search results page should be displayed
    When I filter the bus results to find the cheapest bus
    And I select the cheapest bus available
    And I select Pickup as "<PickupLocation>" & Drop Points as "<DropLocation>"
    And I click to select a seat
    And I reserve a berth seat
    And I proceed to continue

    Examples:
      | PickupLocation  | DropLocation   |
      | Koyambedu       | Electronic City|

  Scenario Outline: Enter the user Details
    And I enter valid traveller details "<name>" "<Age>" "<Email>" "<PhoneNumber>"
    Then I should be navigated to the payment page


    Examples:
      | name  | Age | Email            | PhoneNumber|
      | Gokul | 24  | Gokul@gmail.com  | 6789123456 |
