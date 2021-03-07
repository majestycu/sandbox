Test Solution built with Gradle, Serenity and Cucumber.

The mock APIs used for the testing purposes can be found over: https://any-api.com/getsandbox_com/getsandbox_com/docs/API_Description.

Installation and Running:

1. Clone/Download the project from GitLab;
2. Open the project with IDE;
3. Wait for the packages to get installed;
4. Run the tests with the RunnerClass/Terminal using (gradlew test);

Write New Tests:

1. Create a new feature file over: resources/SandboxFeatures;
2. The feature file should contain all the desired Gherkin scenarios (Given, When, Then);
3. After the feature file is created, start the implementation of the steps provided.

*src\test\java\Helpers\ApiHelper.java => is the main class containing all the API helper methods such as: GET, POST, PUT, DELETE.

*src\test\java\Sandbox\Steps\Serenity\Steps => is the main folder of the steps methods that we will use for implementation of the Gherkin Steps.
Inside the folder we will see 6 classes: Assertion, Common, DeleteSandBox, GetSandBox, PostSandBox, PutSandbox all containing the self explanatory steps for the targeted are;

*src\test\java\Sandbox\Steps\Serenity (one folder up from the previous location) => is the main folder of the Gherkin Steps.
Inside we will have 6 other classes that contain the gherkin implementation for each mentioned class found in the previous step.

For Example:
- *src\test\java\Sandbox\Steps\Serenity\Steps\AssertionSteps will contain the method for 'assertStatusCode'
- *src\test\java\Sandbox\Steps\Serenity\AssertSandBoxSteps will contain the Gherkin implementation for that method: @Then("the response status code is ''")

*src\test\java\Sandbox\Objects is the main folder on where the objects are stored, objects such as SandboxObj, or ResponseSandBoxObj etc.

** How to generate report
** How to run against CI


Sandbox API Documentation


Base Path : https://getsandbox.com/api/
Example of an API call: https://getsandbox.com/api/1/sandboxes/someSandboxName

Version
The current version of the API is V1, the version is part of the URL, so all calls to the API explicitly include the API version.

Authentication

Authentication is done using a Header;
example: curl -i -H"API-Key: (api-key)" https://getsandbox.com/api/1/sandboxes

The API key token is accessible on your account page after you create an account and needs to be sent as a HTTP Header named API-Key.

--------------------------------------------------------------------------------------------------------------------------------------------------------------
1. GET Activity Search
- https://getsandbox.com/api/1/activity/search

Request Parameters
- fromTimestamp  (query)Optional   Integer    Timestamp to start search from, epoch time in milliseconds.
- sourceSandboxes  (query)Optional     String     Comma-separated list of Sandbox names to search.
- keyword  (query)Optional     String     A keyword to search activities by, will match any part of the ActivityMessage.
- allTypes  (query)Optional    Boolean    Flag to return all types of activity, defaults to just Requests
- maxResults  (query)Optional  Integer    Maximum number of results to return

Error Messages: 'sourceSandboxes is required' is displayed if the SourceSandboxes parameter is not present as query param;
GENERAL ERROR MESSAGE: 'Your API Key is invalid.' when trying to make any sort of operation without the auth header;
Returns response type is an array of objects.
--------------------------------------------------------------------------------------------------------------------------------------------------------------

2. GET Sandboxes
- https://getsandbox.com/api/1/sandboxes

Request Parameters
filterType  (query)Optional

Error Messages: 'Sorry, an error has occurred. Please check your request data and try again.' when trying to retrieve the list of sandboxes
Returns response type as object.
--------------------------------------------------------------------------------------------------------------------------------------------------------------

3. POST Sandboxes
- https://getsandbox.com/api/1/sandboxes

Parameters
body

Error Messages: 'Name has invalid characters' when trying to create an entry with forbidden characters.
Response type as object.
--------------------------------------------------------------------------------------------------------------------------------------------------------------

4. GET Sandboxes by name
- https://getsandbox.com/api/1/sandboxes/{sandboxName}

Parameters
sandboxName - Name of the Sandbox

Error messages: 'Failed to retrieve sandbox' when retrieving a non-existing entry by sandbox name.
Returns response type as object.
--------------------------------------------------------------------------------------------------------------------------------------------------------------

5. PUT Sandboxes by name
- https://getsandbox.com/api/1/sandboxes/{sandboxName}

Parameters
sandboxName  -  Name of the Sandbox
body -  Fields to updated on given Sandbox
Requires an object body.

Error Messages: 'Failed to retrieve sandbox' when trying to update a non-existing entry.
Returns response type as object.
--------------------------------------------------------------------------------------------------------------------------------------------------------------

6. DELETE Sandboxes by name
- https://getsandbox.com/api/1/sandboxes/{sandboxName}

Parameters
sandboxName  - Name of the Sandbox

Error Messages: 'Failed to retrieve sandbox' when retrieving non-existent sandbox.

--------------------------------------------------------------------------------------------------------------------------------------------------------------

7. GET Sandboxes by name fork
- https://getsandbox.com/api/1/sandboxes/{sandboxName}/fork

Parameters
sandboxName - Name of the Sandbox

Error Messages: 'Sorry, an error has occurred. Please check your request data and try again.'
Returns - response type Object
--------------------------------------------------------------------------------------------------------------------------------------------------------------

8. GET Sandboxes by state

- https://getsandbox.com/api/1/sandboxes/{sandboxName}/state

Parameters
sandboxName - Name of the Sandbox

--------------------------------------------------------------------------------------------------------------------------------------------------------------

9. DELETE Sandboxes by state
- https://getsandbox.com/api/1/sandboxes/{sandboxName}/state

Parameters
sandboxName - Name of the Sandbox
--------------------------------------------------------------------------------------------------------------------------------------------------------------
