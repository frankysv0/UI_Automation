Feature: Testing Components and Monitors in OpenCart

  Scenario: User validates the list of components and selects a monitor
    Given the user opens the OpenCart homepage
    When the user hovers over the "Components" menu
    And the user clicks on "Show All Components"
    Then the user should see 5 components listed
    When the user clicks on "Monitors (2)"
    Then the user should see a list of monitors and their names
    And the user should see breadcrumbs with a count