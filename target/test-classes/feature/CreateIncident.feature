Feature: Create a incident using POST method

Scenario: create a incident
Given Enter the endpoint
And Provide the authetication details
When send the POST request
Then verify the status code as 201 

Scenario Outline: create a incident using JSON files
Given Enter the endpoint
And Provide the authetication details
When send the POST Request with filename as <filename>
Then verify the status code as 201

Examples:
|filename|
|createIncident|
|CreateIncident1|
