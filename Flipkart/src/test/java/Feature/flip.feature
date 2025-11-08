Feature: Flipkart purchase and social links

  Scenario Outline: Buy first Apple mobile and visit socials
    Given the user is on Flipkart home
    When the user searches for "<Product>"
    And the user opens Apple mobiles
    And the user opens the first product and starts purchase
    And the user returns to home
    And the user opens YouTube from footer and plays a video
    And the user returns to Flipkart
    And the user opens Instagram from footer
    Then Flipkart home is accessible again after returning

    Examples:
      | Product |
      | Watch   |
