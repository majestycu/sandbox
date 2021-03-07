Feature: SandBoxTests Valid Scenarios

Scenario: Create Random SandBox
    Given I create a SandBox with random name
    Then the response status code is '200'


  Scenario: Create Random SandBox - State
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I make a GET state request on previously created Sandbox
    Then the response status code is '200'


  Scenario: Create Random SandBox - OwnerOrganisation Name
    Given I create a SandBox with random name
    Then the response status code is '200'
    And the response should contain the correct details for ownerOrganisation name: 'ionutmanea'


  Scenario: Create Random SandBox - OwnerOrganisation BillingEmail
    Given I create a SandBox with random name
    Then the response status code is '200'
    And the response should contain the correct details for ownerOrganisation billingEmail: 'ionut.mane@gmail.com'


  Scenario: Delete SandBox
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I try to delete the previously created Sandbox
    Then the response status code is '200'
    When I make a GET request on the previously created SandBox
    Then the response status code is '400'
    And the response error message is 'Failed to retrieve sandbox'


  Scenario: Delete SandBox - State
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I try to delete the state on previously created Sandbox
    Then the response status code is '200'


  Scenario: Modify SandBox - Description
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I modify the previously created sandbox with description: 'new description'
    Then the response status code is '200'
    And the response should contain the correct details for description: 'new description'


  Scenario: Modify SandBox - Random Name
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I modify the previously created sandbox with random name
    Then the response status code is '200'
    And the response should contain the newly updated sandbox name


#since its hardcoded value for name it must be different on each run
  Scenario: Modify SandBox - Hardcode Value For Name
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I modify the previously created sandbox with name: 'newname1234567'
    Then the response status code is '200'
    And the response should contain the newly updated sandbox name: 'newname1234567'

