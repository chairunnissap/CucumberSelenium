Feature: Checkout Scenario


Scenario : User can checkout product successfully
    Given User is on the login page
    When User enter valid username and password
    And User click on the login button
    Then User is navigated to the product page
    When User add product to the cart
    And User click on the cart icon
    Then User verify the product is added to the cart
    When User click on the checkout button
    Then User is navigated to the checkout page
    When User fills in the shipping details
    And User click on the place order button
    Then User verify the order is placed successfully