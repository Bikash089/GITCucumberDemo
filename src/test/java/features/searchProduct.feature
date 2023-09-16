Feature: Search and Place the order for Products
@OffersPage
 Scenario Outline: Search Experience for product search in both home and offer page
 
    Given User is on GreenCart landing page
    When user searched with Shortname <Name> and extracted actual name of the product
    Then user searched for <Name> shortname in offers page
    And validate product name in offers page matches with Landing page
   
Examples:
| Name |
| Tom |
| Beet |