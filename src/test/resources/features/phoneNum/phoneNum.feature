@all @determine_phonenum
Feature: Determine activation date of phone number

  Scenario: Still using from first time
    Given usage history of number "0987000001" is
      | activationDate | deactivationDate |
      | 2016-03-01     |                  |

    When looking for activation date of number "0987000001"
    Then activation date should be "2016-03-01"

  Scenario: No one handle right now
    Given usage history of number "0987000001" is
      | activationDate | deactivationDate |
      | 2015-03-01     | 2016-03-01       |

    When looking for activation date of number "0987000001"
    Then activation date should be "2015-03-01"

  Scenario: Already handover
    Given usage history of number "0987000001" is
      | activationDate | deactivationDate |
      | 2016-04-01     |                  |
      | 2015-03-01     | 2016-03-01       |

    When looking for activation date of number "0987000001"
    Then activation date should be "2016-04-01"

  Scenario: Change plan and handover some times
    Given usage history of number "0987000001" is
      | activationDate | deactivationDate |
      | 2016-03-01     | 2016-05-01       |
      | 2016-01-01     | 2016-03-01       |
      | 2016-12-01     |                  |
      | 2016-09-01     | 2016-12-01       |
      | 2016-06-01     | 2016-09-01       |

    When looking for activation date of number "0987000001"
    Then activation date should be "2016-06-01"
