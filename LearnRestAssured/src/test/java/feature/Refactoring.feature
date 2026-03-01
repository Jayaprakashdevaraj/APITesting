Feature: Validate the CURD operation of the serviceNow incident table API

Background:
Given user should set baseuri as "https://dev272818.service-now.com" setup the basic
And user should set basepath as "/api/now/table/" setup the basic
And user should provide basic authentication username as "admin" and password as "lBWvJ1%Tb6/w"


Scenario: validate user should able to fetch all records from the incident table
When user hit the get method and retriva all method from incident table
Then user should see the status should be "200"
And user should see the status line should be "OK"
And user should get the response in the "JSON" format


Scenario: validate user should able to fetch all records from the incident table and get responce as "xml" format
And user should set header key as "Content-Type" and value as "application/xml"
When user hit the get method and retriva all method from incident table
Then user should see the status should be "200"
And user should see the status line should be "OK"
And user should get the response in the "xml" format


Scenario: validate user should create new recored in incident table 
And user should set header key as "Content-Type" and value as "application/json"
And user should give short description as "short descrition"
When user hit the post method to create new record in incident table
Then user should see the status should be "201"
And user should see the status line should be "Created"
And user should get the response in the "xml" format