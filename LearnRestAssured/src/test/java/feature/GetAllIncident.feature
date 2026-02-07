Feature: Validate the CURD operation of the serviceNow incident table API

Scenario: validate user should able to fetch all records from the incident table

Given user should set baseuri as "https://dev272818.service-now.com" setup the basic
And user should set basepath as "/api/now/table/" setup the basic
And user should provide basic authentication username as "admin" and password as "lBWvJ1%Tb6/w"
When user hit the get method and retriva all method from incident table
Then user should see the status should be "200"
And user should see the status line should be "OK"
And user should get the response in the "JSON" format