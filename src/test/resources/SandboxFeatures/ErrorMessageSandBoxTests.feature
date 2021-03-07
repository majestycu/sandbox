Feature: SandBoxTests Error Message Scenarios

Scenario: Error Message - Chosen name already exists
  Given I create a SandBox with name: 'NameExists'
  Then the response status code is '400'
  And the response error message is 'Chosen name already exists'


  Scenario: Error Message - Name has invalid characters
  Given I create a SandBox with name: '%%%%%%%%%%%%%%%%%%%%'
  Then the response status code is '400'
  And the response error message is 'Name has invalid characters'


  Scenario: Error Message - Failed to retrieve sandbox
    Given I make a GET request on sandboxName: '0'
    Then the response status code is '400'
    And the response error message is 'Failed to retrieve sandbox'


  Scenario: Error Message - Your API Key is invalid.
    Given I make a GET request with auth key: 'Invalid Auth Key'
    Then the response status code is '401'
    And the response error message is 'Your API Key is invalid.'


  Scenario: Error Message - SourceSandboxes is required
    Given I make a GET request on Search Activity with queryParam: 'test' and value: 'test'
    Then the response status code is '400'
    And the response error message is 'sourceSandboxes is required'


  Scenario: Error Message - Delete - Failed to retrieve sandbox
    Given I try to delete the sandbox name: 'test deletion'
    Then the response status code is '400'
    And the response error message is 'Failed to retrieve sandbox'


  Scenario: Error Message - Put - Change Existing Sandbox - Name has invalid characters
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I modify the previously created sandbox with name: '%%%%%%%%%%%%%%%%%%%%'
    And the response error message is 'name has invalid characters'


  Scenario: Error Message - Put - Sandbox with that name already exists
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I modify the previously created sandbox with name: 'newname'
    Then the response status code is '400'
    And the response error message is 'Sandbox with that name already exists.'


  Scenario: Error Message - Get Fork - Internal Server Error
    Given I create a SandBox with random name
    Then the response status code is '200'
    When I make a GET fork request on previously created Sandbox
    Then the response status code is '500'
    And the response error message is 'Sorry, an error has occurred. Please check your request data and try again.'