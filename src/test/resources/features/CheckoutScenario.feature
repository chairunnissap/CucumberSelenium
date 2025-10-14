Feature: Checkout functionality

Background: Login
    Given User is on the login page

Scenario: User can checkout product successfully
    When User enter valid username and password
    Then User click on the login button
    When User add product to the cart
    Then User click on the cart icon
    When User verify the product is added to the cart
    Then User click on the checkout button and User fills in the shipping details
    When User overview in the shipping details
    Then User click on the finish button and User verify the order is placed successfully

Scenario Outline: User cannot login with invalid credentials
    When User cannot login with "<username>" and "<password>"

    Examples:
        | username          | password      |
        | standar_user      | secret_sauce  |
        | locked_in_user    | secret_sauce  |
        | problems_user     | secret_sauce  |