#Author: Vaibhav
#Feature: List of scenarios.
#Scenario: Business rule through list of steps 
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps

 Feature: Purchase Men's Clothing on Magento

  Scenario: Purchase Men's Clothing with Registered User
    Given I am on the Magento website
    When I login with valid credentials
    And I add 2 Men's Tops - Jackets and 1 Men's Bottoms - Pants to the cart
    And I proceed to checkout
    And I verify the order summary
    Then I verify the order is submitted and appears under My Orders
